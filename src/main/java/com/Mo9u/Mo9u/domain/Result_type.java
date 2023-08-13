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
}