package com.example.hexagonalarchitecture.account.adapter.in.deposit;


import com.example.hexagonalarchitecture.account.application.port.in.deposit.DepositCommand;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
class DepositRequest {

    @NotNull(message = "계좌번호는 필수값 입니다")
    private String accountNum;
    @NotNull(message = "비밀번호는 필수값 입니다")
    private String accountPassword;
    @NotNull(message = "입금금액은 필수값 입니다")
    private long money;

    DepositCommand toCommand() {
        return DepositCommand.builder()
            .accountNum(accountNum)
            .accountPassword(accountPassword)
            .money(money)
            .build();
    }
}
