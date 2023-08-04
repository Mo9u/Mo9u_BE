package com.Mo9u.Mo9u.web.dto;

import com.Mo9u.Mo9u.domain.Subscribe;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class subscribeDto {
    private Long id;
    private String category;
    private String name;
    private String simpleContent;
    private String[] mainContent;
    private int maxPrice;
    private int avgPrice;
    private int minPrice;
    private String link;

    @Builder
    public subscribeDto(Long id, String category, String name, String simpleContent, String[] mainContent, int maxPrice, int avgPrice, int minPrice, String link){
        this.id = id;
        this.category = category;
        this.name = name;
        this.simpleContent = simpleContent;
        this.mainContent = mainContent;
        this.maxPrice = maxPrice;
        this.avgPrice = avgPrice;
        this.minPrice = minPrice;
        this.link = link;
    }

}
