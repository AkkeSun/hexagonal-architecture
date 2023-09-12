package com.example.hexagonalarchitecture.application.port.in.account;

public interface AccountCreateUseCase {
    AccountDTO createAccount(AccountCreateCommand command);
}
