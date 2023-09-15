package com.example.hexagonalarchitecture.port;

import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.INSUFFICIENT_BALANCE;
import static org.mockito.Mockito.when;

import com.example.hexagonalarchitecture.application.port.in.account.AccountDTO;
import com.example.hexagonalarchitecture.application.port.in.account.WithDrawCommand;
import com.example.hexagonalarchitecture.application.port.out.account.CreateAccountPort;
import com.example.hexagonalarchitecture.application.port.out.account.ReadAccountPort;
import com.example.hexagonalarchitecture.application.port.out.account.UpdateAccountPort;
import com.example.hexagonalarchitecture.application.port.out.user.ReadUserPort;
import com.example.hexagonalarchitecture.application.service.AccountService;
import com.example.hexagonalarchitecture.domain.Account;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WithDrawUseCaseTest {

    String accountNum;
    int accountPassword;

    @Mock
    CreateAccountPort createAccountPort;

    @Mock
    UpdateAccountPort updateAccountPort;

    @Mock
    ReadAccountPort loadAccountPort;

    @Mock
    ReadUserPort loadUserPort;

    @InjectMocks
    AccountService withDrawUseCase;

    @BeforeEach
    void setup() {
        this.accountNum = "123-123-12-123";
        this.accountPassword = 1234;
    }

    @Test
    @DisplayName("[Failed] 출금 잔액이 부족한 경우 예외가 발생하는지 테스트")
    void getAccount_entitySearchError() {
        // given
        WithDrawCommand command = new WithDrawCommand();
        command.setAccountNum(accountNum);
        command.setAccountPassword(accountPassword);
        command.setMoney(10000000000000L);

        when(loadAccountPort.getAccount(accountNum, accountPassword)).thenReturn(Account.builder()
            .accountNum(accountNum)
            .accountPassword(accountPassword)
            .userIndex(12)
            .money(5000)
            .build());

        try {
            // when
            withDrawUseCase.withDraw(command);
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), INSUFFICIENT_BALANCE);
        }
    }

    @Test
    @DisplayName("[Success] 출금 성공")
    void getAccount_success() {
        // given
        WithDrawCommand command = new WithDrawCommand();
        command.setAccountNum(accountNum);
        command.setAccountPassword(accountPassword);
        command.setMoney(3000);

        when(loadAccountPort.getAccount(accountNum, accountPassword)).thenReturn(Account.builder()
            .accountNum(accountNum)
            .accountPassword(accountPassword)
            .userIndex(12)
            .money(5000)
            .build());

        // when
        AccountDTO result =  withDrawUseCase.withDraw(command);

        // then
        Assertions.assertEquals(result.getMessage(), "출금이 완료 되었습니다");
    }
}
