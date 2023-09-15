package com.example.hexagonalarchitecture.application.port.in.account;

/*
    도메인의 기능을 하나씩 정의
 */
public interface AccountCreateUseCase {
    AccountDTO createAccount(AccountCreateCommand command);
}
