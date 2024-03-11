package com.example.hexagonalarchitecture.adapter.in.withDraw;


import com.example.hexagonalarchitecture.application.port.in.withdraw.WithdrawCommand;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
class WithdrawRequest {

    @NotNull(message = "계좌번호는 필수값 입니다")
    private String accountNum;

    @NotNull(message = "비밀번호는 필수값 입니다")
    private String accountPassword;

    @NotNull(message = "출금액은 필수값 입니다")
    private Long money;

    WithdrawCommand toCommand() {
        return WithdrawCommand.builder()
            .accountNum(this.accountNum)
            .accountPassword(this.accountPassword)
            .money(this.money)
            .build();
    }

}
