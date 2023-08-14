package com.Mo9u.Mo9u.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
public class Sub_manage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_manage_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Subscribe subscribe;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private User user;

    @Column
    private LocalDate creditDate;

    @Column
    private int creditPrice;

    @Builder
    public Sub_manage(Long id, Subscribe subscribe, User user, LocalDate creditDate, int creditPrice){
        this.id = id;
        this.subscribe = subscribe;
        this.user = user;
        this.creditDate = creditDate;
        this.creditPrice = creditPrice;
    }
}
