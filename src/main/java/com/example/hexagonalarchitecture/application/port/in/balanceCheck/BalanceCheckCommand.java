package com.example.hexagonalarchitecture.application.port.in.balanceCheck;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BalanceCheckCommand {

    private String accountNum;

    private String accountPassword;

    @Builder
    public BalanceCheckCommand(String accountNum, String accountPassword) {
        this.accountNum = accountNum;
        this.accountPassword = accountPassword;
    }
}
