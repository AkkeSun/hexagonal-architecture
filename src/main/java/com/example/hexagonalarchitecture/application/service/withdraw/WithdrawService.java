package com.example.hexagonalarchitecture.application.service.withdraw;

import static com.example.hexagonalarchitecture.global.exception.ErrorCode.AMOUNT_IS_INSUFFICIENT;

import com.example.hexagonalarchitecture.application.port.in.withdraw.WithdrawCommand;
import com.example.hexagonalarchitecture.application.port.in.withdraw.WithdrawUseCase;
import com.example.hexagonalarchitecture.application.port.out.AccountCreatePort;
import com.example.hexagonalarchitecture.application.port.out.AccountReadPort;
import com.example.hexagonalarchitecture.domain.Account;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class WithdrawService implements WithdrawUseCase {

    private final AccountReadPort accountReadPort;

    private final AccountCreatePort accountCreatePort;

    @Override
    @Transactional
    public WithdrawServiceResponse withdraw(WithdrawCommand command) {
        Account account = accountReadPort.getAccount(command.getAccountNum(),
            command.getAccountPassword());

        boolean isSuccess = account.withdraw(command.getMoney());
        if (!isSuccess) {
            throw new CustomException(AMOUNT_IS_INSUFFICIENT);
        }
        accountCreatePort.save(account);
        return new WithdrawServiceResponse(true);
    }
}
