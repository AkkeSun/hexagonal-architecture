package com.example.hexagonalarchitecture.application.service;

import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.INSUFFICIENT_BALANCE;
import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.USER_INFO_NOT_FOUND;

import com.example.hexagonalarchitecture.application.port.in.account.AccountCreateCommand;
import com.example.hexagonalarchitecture.application.port.in.account.AccountCreateUseCase;
import com.example.hexagonalarchitecture.application.port.in.account.DepositCommand;
import com.example.hexagonalarchitecture.application.port.in.account.DepositUseCase;
import com.example.hexagonalarchitecture.application.port.in.account.AccountSearchCommand;
import com.example.hexagonalarchitecture.application.port.in.account.AccountSearchUseCase;
import com.example.hexagonalarchitecture.application.port.in.account.WithDrawCommand;
import com.example.hexagonalarchitecture.application.port.in.account.WithDrawUseCase;
import com.example.hexagonalarchitecture.application.port.in.account.AccountDTO;
import com.example.hexagonalarchitecture.application.port.out.account.CreateAccountPort;
import com.example.hexagonalarchitecture.application.port.out.account.ReadAccountPort;
import com.example.hexagonalarchitecture.application.port.out.user.ReadUserPort;
import com.example.hexagonalarchitecture.application.port.out.account.UpdateAccountPort;
import com.example.hexagonalarchitecture.domain.Account;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
    순수한 비지니스 로직만 작성한다
 */
@Service
@RequiredArgsConstructor
public class AccountService implements DepositUseCase, WithDrawUseCase, AccountSearchUseCase,
    AccountCreateUseCase {

    private final CreateAccountPort createAccountPort;
    private final UpdateAccountPort updateAccountPort;
    private final ReadAccountPort loadAccountPort;
    private final ReadUserPort loadUserPort;

    @Override
    public AccountDTO createAccount(AccountCreateCommand command) {
        command.validate();
        if(!loadUserPort.existUser(command.getUserIndex())){
            throw new ApiException(USER_INFO_NOT_FOUND);
        }
        String accountNum = generateAccountNum(command.getUserIndex());
        createAccountPort.create(Account.builder()
            .accountNum(generateAccountNum(command.getUserIndex()))
            .accountPassword(command.getAccountPassword())
            .userIndex(command.getUserIndex())
            .money(command.getMoney())
            .build());
        return AccountDTO.ofSuccess("신규 계좌가 등록되었습니다 - " + accountNum);
    }

    @Override
    public AccountDTO getAccount(AccountSearchCommand command) {
        command.validate();
        Account account =
            loadAccountPort.getAccount(command.getAccountNum(), command.getAccountPassword());
        return AccountDTO.ofSuccess("조회된 금액 : " + account.getMoney());
    }

    @Override
    public AccountDTO withDraw(WithDrawCommand command) {
        command.validate();
        Account account =
            loadAccountPort.getAccount(command.getAccountNum(), command.getAccountPassword());
        if(account.withdraw(command.getMoney())) {
            updateAccountPort.update(account);
            return AccountDTO.ofSuccess("출금이 완료 되었습니다");
        }
        throw new ApiException(INSUFFICIENT_BALANCE);
    }

    @Override
    public AccountDTO deposit(DepositCommand command) {
        command.validate();
        Account account =
            loadAccountPort.getAccount(command.getAccountNum(), command.getAccountPassword());
        account.deposit(command.getMoney());
        updateAccountPort.update(account);
        return AccountDTO.ofSuccess("입금이 완료 되었습니다");
    }

    private String generateAccountNum(long userIndex) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        String accountNum = String.valueOf(userIndex + (random.nextInt(90000000) + 10000000));
        if(loadAccountPort.existAccountNum(accountNum)){
            return generateAccountNum(userIndex);
        }
        return accountNum;
    }

}
