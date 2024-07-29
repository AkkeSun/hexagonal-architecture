package com.example.hexagonalarchitecture.adapter.in.controller.balanceCheck;

import com.example.hexagonalarchitecture.application.port.in.balanceCheck.BalanceCheckCommand;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
class BalanceCheckRequest {

    @NotBlank(message = "계좌번호는 필수값 입니다")
    private String accountNum;

    @NotBlank(message = "비밀번호는 필수값 입니다")
    private String accountPassword;

    BalanceCheckCommand toCommand() {
        return BalanceCheckCommand.builder()
            .accountNum(this.accountNum)
            .accountPassword(this.accountPassword)
            .build();
    }
}
