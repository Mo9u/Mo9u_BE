package com.Mo9u.Mo9u.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class Subscribe {

    @Id
    @Column(name = "sub_id")
    private Long id;

    @Column(name = "sub_category")
    private String category;

    @Column(name = "sub_name")
    private String name;

    @Column(name = "sub_simple_content")
    private String simpleContent;

    @Column(name = "sub_content")
    private String mainContent;

    @Column(name = "sub_price_max")
    private int maxPrice;

    @Column(name = "sub_price_avg")
    private int avgPrice;

    @Column(name = "sub_price_min")
    private int minPrice;

    @Column(name = "sub_link")
    private String link;

    @Builder
    public Subscribe(Long id, String category, String name, String simpleContent, String mainContent, int maxPrice, int avgPrice, int minPrice, String link){
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
