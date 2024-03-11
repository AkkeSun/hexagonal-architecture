package com.example.hexagonalarchitecture.application.service.balanceCheck;

import com.example.hexagonalarchitecture.application.port.in.balanceCheck.BalanceCheckCommand;
import com.example.hexagonalarchitecture.application.port.in.balanceCheck.BalanceCheckUseCase;
import com.example.hexagonalarchitecture.application.port.out.AccountReadPort;
import com.example.hexagonalarchitecture.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BalanceCheckService implements BalanceCheckUseCase {

    private final AccountReadPort accountReadPort;

    @Override
    public BalanceCheckServiceResponse getBalance(BalanceCheckCommand command) {
        Account account = accountReadPort.getAccount(command.getAccountNum(),
            command.getAccountPassword());
        return new BalanceCheckServiceResponse(account.getMoney());
    }
}
