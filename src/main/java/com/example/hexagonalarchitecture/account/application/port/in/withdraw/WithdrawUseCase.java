package com.example.hexagonalarchitecture.account.application.port.in.withdraw;

import com.example.hexagonalarchitecture.account.application.service.withdraw.WithdrawServiceResponse;

public interface WithdrawUseCase {

    WithdrawServiceResponse withdraw(WithdrawCommand command);

}
