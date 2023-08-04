package com.Mo9u.Mo9u.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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
}
