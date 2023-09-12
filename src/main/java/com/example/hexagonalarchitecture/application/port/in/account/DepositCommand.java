package com.example.hexagonalarchitecture.application.port.in.account;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

/*
    input model
    유스케이스 별로 입력 모델을 만들어준다
    입력값 유효성 검증은 인풋모델에서 처리한다
 */
@Getter
@Setter
public class DepositCommand {

    @NotNull // 유효성 검증
    private int accountNum;
    @NotNull
    private int accountPassword;
    @NotNull
    private long money;
}
