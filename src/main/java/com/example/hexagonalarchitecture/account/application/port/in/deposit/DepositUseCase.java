package com.example.hexagonalarchitecture.account.application.port.in.deposit;

import com.example.hexagonalarchitecture.account.application.service.deposit.DepositServiceResponse;

public interface DepositUseCase {

    DepositServiceResponse deposit(DepositCommand command);
}
