package com.Mo9u.Mo9u.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Result_type {

    @Id
    @Column(name = "result_id")
    private Long id;

    @Column(name = "result_content")
    private String content;

    @OneToOne
    @JoinColumn(name="sub_id")
    private Subscribe subscribe;

    @Column(name="result_intro")
    private String intro;

    @Column(name = "result_name")
    private String name;

    @Column(name = "result_img")
    private String resImage;

    @Builder
    public Result_type(Long id, String content, Subscribe subscribe, String intro, String name, String resImage){
        this.id = id;
        this.content = content;
        this.subscribe = subscribe;
        this.intro = intro;
        this.name = name;
        this.resImage = resImage;
    }
}