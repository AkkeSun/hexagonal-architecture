package com.example.hexagonalarchitecture.account.domain;

import lombok.Builder;
import lombok.Getter;

/*
    Domain
    - 외부로 향하는 의존성이 없어야한다
    - Spring 어노테이션이 없는 순수 java POJO
 */
@Builder
@Getter
public class Account {

    private Long index;

    private String accountNum;

    private String accountPassword;

    private long money;

    private long userIndex;


    @Builder
    public Account(Long index, String accountNum, String accountPassword, long money,
        long userIndex) {
        this.index = index;
        this.accountNum = accountNum;
        this.accountPassword = accountPassword;
        this.money = money;
        this.userIndex = userIndex;
    }

    public boolean withdraw(long inputMoney) {
        this.money -= inputMoney;
        return this.money >= 0;
    }

    public void deposit(long inputMoney) {
        this.money += inputMoney;
    }

}
