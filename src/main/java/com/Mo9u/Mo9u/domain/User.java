package com.Mo9u.Mo9u.domain;

<<<<<<< HEAD
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class User {
    @Id
    @Column(name = "user_id")
    private Long userId;
=======
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;

@Getter
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

    @OneToMany(mappedBy = "userId")
    private List<Sub_manage> manages = new ArrayList<>();
>>>>>>> 5648c0809e4f242f305ac18973e1b9fbcc43c45d
}
