package com.example.hexagonalarchitecture.application.port.in.withdraw;

import com.example.hexagonalarchitecture.application.service.withdraw.WithdrawServiceResponse;

public interface WithdrawUseCase {

    WithdrawServiceResponse withdraw(WithdrawCommand command);

}
