package com.example.restaurant.wishlist.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.wishlist.entity.WishListEntity;
import com.example.restaurant.wishlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;
    private final WishListRepository wishListRepository;

    public WishListDto saerch(String query) {
        // 지역 검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.searchLocal(searchLocalReq);
        if (searchLocalRes.getTotal() > 0) {
            var localItem = searchLocalRes.getItems().stream().findFirst().get();
            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            // 이미지 검색
            var searchImageRes = naverClient.searchImage(searchImageReq);
            if (searchImageRes.getTotal() > 0) {
                var imageItem = searchImageRes.getItems().stream().findFirst().get();
                // 결과 리턴
                return WishListDto.builder()
                        .title(localItem.getTitle().replaceAll("<[^>]*>", ""))
                        .category(localItem.getCategory())
                        .address(localItem.getAddress())
                        .roadAddress(localItem.getRoadAddress())
                        .homePageLink(localItem.getLink())
                        .imageLink(imageItem.getLink())
                        .build();
            }
        }
        return new WishListDto();
    }

    public WishListDto add(WishListDto wishListDto) {
        var entity = dtoToEntity(wishListDto);
        var saveEntity = wishListRepository.save(entity);
        return entityToDto(saveEntity);
    }

    private WishListEntity dtoToEntity(WishListDto wishListDto) {
        return WishListEntity.builder()
                .title(wishListDto.getTitle())
                .category(wishListDto.getCategory())
                .address(wishListDto.getAddress())
                .roadAddress(wishListDto.getRoadAddress())
                .homePageLink(wishListDto.getHomePageLink())
                .imageLink(wishListDto.getImageLink())
                .isVisit(wishListDto.isVisit())
                .visitCount(wishListDto.getVisitCount())
                .lastVisitDate(wishListDto.getLastVisitDate())
                .build();
    }

    private WishListDto entityToDto(WishListEntity wishListEntity) {
        return WishListDto.builder()
                .index(wishListEntity.getIndex())
                .title(wishListEntity.getTitle())
                .category(wishListEntity.getCategory())
                .address(wishListEntity.getAddress())
                .roadAddress(wishListEntity.getRoadAddress())
                .homePageLink(wishListEntity.getHomePageLink())
                .imageLink(wishListEntity.getImageLink())
                .isVisit(wishListEntity.isVisit())
                .visitCount(wishListEntity.getVisitCount())
                .lastVisitDate(wishListEntity.getLastVisitDate())
                .build();
    }

    public List<WishListDto> findAll() {
        return wishListRepository.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public void delete(int index) {
        wishListRepository.deleteById(index);
    }

    public void addVisit(int index) {
        var wishItem = wishListRepository.findById(index);
        if(wishItem.isPresent()){
            var item = wishItem.get();
            item.setVisit(true);
            item.setVisitCount(item.getVisitCount()+1);
        }
    }
}
