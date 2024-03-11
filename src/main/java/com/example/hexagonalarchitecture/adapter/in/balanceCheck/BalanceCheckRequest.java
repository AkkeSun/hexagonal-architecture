package com.example.hexagonalarchitecture.adapter.in.balanceCheck;

import com.example.hexagonalarchitecture.application.port.in.balanceCheck.BalanceCheckCommand;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
class BalanceCheckRequest {

    @NotNull(message = "계좌번호는 필수값 입니다")
    private String accountNum;

    @NotNull(message = "비밀번호는 필수값 입니다")
    private String accountPassword;

    public BalanceCheckCommand toCommand() {
        return BalanceCheckCommand.builder()
            .accountNum(this.accountNum)
            .accountPassword(this.accountPassword)
            .build();
    }
}
