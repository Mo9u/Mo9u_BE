package com.Mo9u.Mo9u.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
public class How_exit {

    @Id
    @Column(name = "how_exit_id")
    private Long id;

    @Column(name = "how_exit_img")
    private String howImage;

    @Column(name = "how_exit_explain")
    private String howExplain;

    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Subscribe subscribe;
}
