package com.example.hexagonalarchitecture.application.port.in.balanceCheck;

import com.example.hexagonalarchitecture.application.service.balanceCheck.BalanceCheckServiceResponse;

public interface BalanceCheckUseCase {

    BalanceCheckServiceResponse getBalance(BalanceCheckCommand command);
}
