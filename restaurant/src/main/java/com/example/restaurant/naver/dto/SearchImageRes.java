package com.example.restaurant.naver.dto;

import lombok.*;

import java.util.List;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class SearchImageRes {

    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private String category;
    private List<SearchImageItem> items;

    @Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
    public static class SearchImageItem {
        private String title;
        private String link;
        private String thumbnail;
        private String sizeheight;
        private String sizewidth;
    }
}
