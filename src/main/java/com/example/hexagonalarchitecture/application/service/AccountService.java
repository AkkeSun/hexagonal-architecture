package com.example.hexagonalarchitecture.application.service;

import com.example.hexagonalarchitecture.application.port.in.account.AccountCreateCommand;
import com.example.hexagonalarchitecture.application.port.in.account.AccountCreateUseCase;
import com.example.hexagonalarchitecture.application.port.in.account.DepositCommand;
import com.example.hexagonalarchitecture.application.port.in.account.DepositUseCase;
import com.example.hexagonalarchitecture.application.port.in.account.AccountSearchCommand;
import com.example.hexagonalarchitecture.application.port.in.account.AccountSearchUseCase;
import com.example.hexagonalarchitecture.application.port.in.account.WithDrawCommand;
import com.example.hexagonalarchitecture.application.port.in.account.WithDrawUseCase;
import com.example.hexagonalarchitecture.application.port.in.account.AccountDTO;
import com.example.hexagonalarchitecture.application.port.out.CreateAccountPort;
import com.example.hexagonalarchitecture.application.port.out.ReadAccountPort;
import com.example.hexagonalarchitecture.application.port.out.ReadUserPort;
import com.example.hexagonalarchitecture.application.port.out.UpdateAccountPort;
import com.example.hexagonalarchitecture.domain.Account;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/*
    순수한 비지니스 로직만 작성한다
     - input validation 은 command 에서 처리한다
     - input port 상속
     - output port 주입
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
        if(!command.validateSuccess()){
            return AccountDTO.ofFailed("비밀번호와 비밀번호 확인이 올바르지 않습니다");
        }
        if(!loadUserPort.existUser(command.getUserIndex())){
            return AccountDTO.ofFailed("존재하지 않는 사용자 정보 입니다");
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
        Account account = getAccount(command.getAccountNum(), command.getAccountPassword());
        if(ObjectUtils.isEmpty(account)) {
            return AccountDTO.ofFailed("계좌정보가 올바르지 않습니다");
        }
        return AccountDTO.ofSuccess("조회된 금액 : " + account.getMoney());
    }

    @Override
    public AccountDTO withDraw(WithDrawCommand command) {
        Account account = getAccount(command.getAccountNum(), command.getAccountPassword());
        if(ObjectUtils.isEmpty(account)) {
            return AccountDTO.ofFailed("계좌정보가 올바르지 않습니다");
        }
        if(account.withdraw(command.getMoney())) {
            updateAccountPort.update(account);
            return AccountDTO.ofSuccess("출금이 완료 되었습니다");
        } else {
            return AccountDTO.ofFailed("잔액이 부족합니다");
        }
    }

    @Override
    public AccountDTO deposit(DepositCommand command) {
        Account account = getAccount(command.getAccountNum(), command.getAccountPassword());
        if(ObjectUtils.isEmpty(account)) {
            return AccountDTO.ofFailed("계좌정보가 올바르지 않습니다");
        }
        account.deposit(command.getMoney());
        updateAccountPort.update(account);
        return AccountDTO.ofSuccess("입금이 완료 되었습니다");
    }

    private Account getAccount (int accountNum, int accountPassword) {
        try {
            return loadAccountPort.getAccount(accountNum, accountPassword);
        } catch (RuntimeException e) {
            return null;
        }
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
