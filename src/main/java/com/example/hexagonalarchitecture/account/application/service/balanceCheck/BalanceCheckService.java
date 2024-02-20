package com.example.hexagonalarchitecture.account.application.service.balanceCheck;

import com.example.hexagonalarchitecture.account.application.port.in.balanceCheck.BalanceCheckCommand;
import com.example.hexagonalarchitecture.account.application.port.in.balanceCheck.BalanceCheckUseCase;
import com.example.hexagonalarchitecture.account.application.port.out.AccountReadPort;
import com.example.hexagonalarchitecture.account.domain.Account;
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
