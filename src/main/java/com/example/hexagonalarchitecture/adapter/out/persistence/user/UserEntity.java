package com.example.hexagonalarchitecture.adapter.out.persistence.user;

import com.example.hexagonalarchitecture.adapter.out.persistence.account.AccountEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TBL_USER")
public class UserEntity {

    @Id
    @Column(name = "INDEX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "JUMIN")
    private String jumin;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}

/*
    create table TBL_USER
    (
        `INDEX`      int auto_increment
            primary key,
        USER_NAME    varchar(50) null,
        JUMIN        varchar(50) null,
        PHONE_NUMBER varchar(50) null
    );

 */