package com.Mo9u.Mo9u.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class How_sub {

    @Id
    @Column(name = "how_sub_id")
    private Long id;

    @Column(name = "how_sub_img")
    private String howImage;

    @Column(name = "how_sub_explain")
    private String howExplain;

    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Subscribe subscribe;
}
