package com.example.hexagonalarchitecture.adapter.out.persistence.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TBL_ACCOUNT")
public class AccountEntity {

    @Id
    @Column(name = "INDEX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    @Column(name = "ACCOUNT_NUM")
    private String accountNum;

    @Column(name = "ACCOUNT_PASSWORD")
    private String accountPassword;

    @Column(name = "MONEY")
    private long money;

    @Column(name="USER_INDEX")
    private long userIndex;

    void setMoeny(long money) {
        this.money = money;
    }

}

/*
    create table TBL_ACCOUNT
    (
        `INDEX`          int auto_increment
            primary key,
        ACCOUNT_NUM      varchar(50) null,
        ACCOUNT_PASSWORD varchar(50) null,
        MONEY            int         null,
        USER_INDEX       int         null,
        constraint TBL_ACCOUNT_USER_null_fk
            foreign key (USER_INDEX) references dbsewoomch.USER (`INDEX`)
    );
 */
