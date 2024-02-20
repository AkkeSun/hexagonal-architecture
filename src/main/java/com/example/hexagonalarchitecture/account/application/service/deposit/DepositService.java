package com.example.hexagonalarchitecture.account.application.service.deposit;

import com.example.hexagonalarchitecture.account.application.port.in.deposit.DepositCommand;
import com.example.hexagonalarchitecture.account.application.port.in.deposit.DepositUseCase;
import com.example.hexagonalarchitecture.account.application.port.out.AccountCreatePort;
import com.example.hexagonalarchitecture.account.application.port.out.AccountReadPort;
import com.example.hexagonalarchitecture.account.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class DepositService implements DepositUseCase {

    private final AccountReadPort loadAccountPort;

    private final AccountCreatePort saveAccountPort;

    @Override
    @Transactional
    public DepositServiceResponse deposit(DepositCommand command) {
        Account account = loadAccountPort.getAccount(command.getAccountNum(),
            command.getAccountPassword());

        account.deposit(command.getMoney());
        saveAccountPort.save(account);
        return new DepositServiceResponse(true);
    }
}
