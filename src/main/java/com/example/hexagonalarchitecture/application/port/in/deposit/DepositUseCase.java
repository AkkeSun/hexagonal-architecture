package com.example.hexagonalarchitecture.application.port.in.deposit;

import com.example.hexagonalarchitecture.application.service.deposit.DepositServiceResponse;

public interface DepositUseCase {

    DepositServiceResponse deposit(DepositCommand command);
}
