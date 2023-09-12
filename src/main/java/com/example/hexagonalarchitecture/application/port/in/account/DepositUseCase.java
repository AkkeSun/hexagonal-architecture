package com.example.hexagonalarchitecture.application.port.in.account;

public interface DepositUseCase {

    AccountDTO deposit(DepositCommand sendMoneyCommand);
}
