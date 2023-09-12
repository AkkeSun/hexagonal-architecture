package com.example.hexagonalarchitecture.application.port.in.account;

public interface AccountSearchUseCase {
    AccountDTO getAccount(AccountSearchCommand searchCommand);
}
