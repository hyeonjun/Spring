package com.example.restaurant.wishlist.repository;

import com.example.restaurant.wishlist.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create() {
        return WishListEntity.builder()
                        .title("title")
                        .category("category")
                        .address("address")
                        .roadAddress("roadAddress")
                        .homePageLink("")
                        .imageLink("")
                        .isVisit(false)
                        .visitCount(0)
                        .lastVisitDate(null).build();
    }

    @Test
    public void saveTest() {
        var wishList = create();
        var expected = wishListRepository.save(wishList);
        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getIndex());
    }

    @Test
    public void updateTest() {
        var wishList = create();
        var expected = wishListRepository.save(wishList);

        expected.setTitle("update test");
        var saveEntity = wishListRepository.save(expected);

        Assertions.assertEquals("update test", saveEntity.getTitle());
        Assertions.assertEquals(1, wishListRepository.findAll().size());
    }

    @Test
    public void findByIdTest() {
        var wishList = create();
        wishListRepository.save(wishList);

        var expected = wishListRepository.findById(1);
        Assertions.assertTrue(expected.isPresent());
        Assertions.assertEquals(1, expected.get().getIndex());

    }

    @Test
    public void deleteTest() {
        var wishList = create();
        wishListRepository.save(wishList);
        wishListRepository.deleteById(1);

        Assertions.assertEquals(0, wishListRepository.findAll().size());
    }

    @Test
    public void listAllTest() {
        var wishList1 = create();
        wishListRepository.save(wishList1);

        var wishList2 = create();
        wishListRepository.save(wishList2);

        Assertions.assertEquals(2, wishListRepository.findAll().size());
    }

}
