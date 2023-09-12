package com.example.hexagonalarchitecture.domain;

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

    private int accountNum;
    private int accountPassword;
    private long money;
    private User user;

    public boolean withdraw(long inputMoney) {
        if(this.money < 0) {
            return false;
        }
        this.money -= inputMoney;
        return true;
    }

    public void deposit(long inputMoney) {
        this.money += inputMoney;
    }

}
