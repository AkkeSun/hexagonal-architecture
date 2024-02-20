package com.example.hexagonalarchitecture.account.application.port.in.withdraw;

import lombok.Builder;
import lombok.Getter;

@Getter
public class WithdrawCommand {

    private String accountNum;
    private String accountPassword;
    private long money;

    @Builder
    public WithdrawCommand(String accountNum, String accountPassword, long money) {
        this.accountNum = accountNum;
        this.accountPassword = accountPassword;
        this.money = money;
    }
}
