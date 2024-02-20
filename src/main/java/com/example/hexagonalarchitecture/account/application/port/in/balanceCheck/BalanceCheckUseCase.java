package com.example.hexagonalarchitecture.account.application.port.in.balanceCheck;

import com.example.hexagonalarchitecture.account.application.service.balanceCheck.BalanceCheckServiceResponse;

public interface BalanceCheckUseCase {

    BalanceCheckServiceResponse getBalance(BalanceCheckCommand command);
}
