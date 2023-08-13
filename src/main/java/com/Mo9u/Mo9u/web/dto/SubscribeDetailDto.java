package com.Mo9u.Mo9u.web.dto;

import lombok.*;

@NoArgsConstructor
@Getter
public class SubscribeDetailDto {
    private Long id;
    private String category;
    private String mainImage;
    private String name;
    private String simpleContent;
    private String[] mainContent;
    private int maxPrice;
    private int avgPrice;
    private int minPrice;
    private String link;

    private String[] howSubImg;
    private String[] howSubExplain;

    private String[] howExitImg;
    private String[] howExitExplain;


    @Builder
    public SubscribeDetailDto(Long id, String category, String mainImage, String name, String simpleContent, String[] mainContent, int maxPrice, int avgPrice, int minPrice, String link, String[] howSubImg, String[] howSubExplain, String[] howExitImg, String[] howExitExplain){
        this.id = id;
        this.category = category;
        this.mainImage = mainImage;
        this.name = name;
        this.simpleContent = simpleContent;
        this.mainContent = mainContent;
        this.maxPrice = maxPrice;
        this.avgPrice = avgPrice;
        this.minPrice = minPrice;
        this.link = link;
        this.howSubImg = howSubImg;
        this.howSubExplain = howSubExplain;
        this.howExitImg = howExitImg;
        this.howExitExplain = howExitExplain;
    }
}
