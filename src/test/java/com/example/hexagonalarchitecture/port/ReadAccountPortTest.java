package com.example.hexagonalarchitecture.port;

import static com.example.hexagonalarchitecture.infrastructure.exception.ApiErrorCode.INVALID_ACCOUNT_INFO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.hexagonalarchitecture.adapter.out.persistence.account.AccountEntity;
import com.example.hexagonalarchitecture.adapter.out.persistence.account.AccountMapper;
import com.example.hexagonalarchitecture.adapter.out.persistence.account.AccountPersistenceAdapter;
import com.example.hexagonalarchitecture.adapter.out.persistence.account.AccountRepository;
import com.example.hexagonalarchitecture.domain.Account;
import com.example.hexagonalarchitecture.infrastructure.exception.ApiException;
import com.example.hexagonalarchitecture.infrastructure.util.AesUtils;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ReadAccountPortTest {

    String accountNum;
    int accountPassword;

    @Spy
    AccountMapper accountMapper;

    @Mock
    AccountRepository repository;

    @InjectMocks
    AccountPersistenceAdapter readAccountPort;

    @BeforeEach
    void setup (){
        this.accountNum = "123-123-12-123";
        this.accountPassword = 1234;
    }

    @Test
    @DisplayName("[Failed] 조회된 정보가 없는 경우 예외가 발생하는지 테스트")
    void getAccount_entitySearchError() {
        // given
        when(repository.findByAccountNumAndAccountPassword(any(), any()))
            .thenReturn(Optional.empty());

        try {
            // when
            readAccountPort.getAccount(accountNum, accountPassword);
        } catch (ApiException e) {
            // then
            Assertions.assertEquals(e.getApiErrorCode(), INVALID_ACCOUNT_INFO);
        }
    }

    @Test
    @DisplayName("[Success] 조회 성공 후 Account Mapping 이 정상적으로 되는지 테스트")
    void getAccount_success() {
        // given
        long userIndex = 10;
        long money = 10000;
        AccountEntity entity = AccountEntity.builder()
            .accountNum(AesUtils.encrypt(accountNum))
            .accountPassword(AesUtils.encrypt(String.valueOf(accountPassword)))
            .userIndex(userIndex)
            .money(money)
            .build();
        when(repository.findByAccountNumAndAccountPassword(any(), any())).thenReturn(Optional.of(entity));

        // when
        Account account = readAccountPort.getAccount(accountNum, accountPassword);

        // then
        Assertions.assertEquals(accountNum, account.getAccountNum());
        Assertions.assertEquals(accountPassword, account.getAccountPassword());
        Assertions.assertEquals(userIndex, account.getUserIndex());
        Assertions.assertEquals(money, account.getMoney());
    }
}
