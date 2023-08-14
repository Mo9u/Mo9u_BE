package com.Mo9u.Mo9u.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@Entity(name = "member")
public class User {

    @Id
    @GeneratedValue()
    @Column(name = "member_id")
    private Long id;

    @Column
    private String loginId;

    @Column
    private String loginPassword;

    @Column
    private String userName;

    @Column
    private String userTel;

    @Column
    private boolean reception;

    @OneToMany(mappedBy = "user")
    private List<Sub_manage> manages = new ArrayList<>();

    public User(Long id, String loginId, String loginPassword, String userName, String userTel, boolean reception, List<Sub_manage> manages){
        this.id = id;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.userName = userName;
        this.userTel = userTel;
        this.reception = reception;
        this.manages = manages;
    }
}
