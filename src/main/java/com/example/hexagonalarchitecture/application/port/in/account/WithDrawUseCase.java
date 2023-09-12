package com.example.hexagonalarchitecture.application.port.in.account;

/*
    하나의 역할만을 수행한다
 */
public interface WithDrawUseCase {

    AccountDTO withDraw(WithDrawCommand withDrawCommand);
}
