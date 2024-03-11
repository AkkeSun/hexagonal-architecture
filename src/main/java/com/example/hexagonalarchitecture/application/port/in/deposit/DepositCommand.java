package com.example.hexagonalarchitecture.application.port.in.deposit;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DepositCommand {

    private String accountNum;
    private String accountPassword;
    private long money;

    @Builder
    public DepositCommand(String accountNum, String accountPassword, long money) {
        this.accountNum = accountNum;
        this.accountPassword = accountPassword;
        this.money = money;
    }
}
