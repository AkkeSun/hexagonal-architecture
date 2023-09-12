package com.example.hexagonalarchitecture.adapter.in.web;

import com.example.hexagonalarchitecture.application.port.in.account.DepositCommand;
import com.example.hexagonalarchitecture.application.port.in.account.DepositUseCase;
import com.example.hexagonalarchitecture.application.port.in.account.AccountSearchCommand;
import com.example.hexagonalarchitecture.application.port.in.account.AccountSearchUseCase;
import com.example.hexagonalarchitecture.application.port.in.account.WithDrawCommand;
import com.example.hexagonalarchitecture.application.port.in.account.WithDrawUseCase;
import com.example.hexagonalarchitecture.application.port.in.account.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountSearchUseCase searchUseCase;
    private final DepositUseCase depositUseCase;
    private final WithDrawUseCase withDrawUseCase;

    @PostMapping
    public ResponseEntity<AccountDTO> searchAccount (AccountSearchCommand searchCommand) {
        return ResponseEntity.ok(searchUseCase.getAccount(searchCommand));
    }

    @PostMapping("/deposit")
    public ResponseEntity<AccountDTO> deposit(DepositCommand depositCommand){
        return ResponseEntity.ok(depositUseCase.deposit(depositCommand));
    }

    @PostMapping("/withDraw")
    public ResponseEntity<AccountDTO> withDrawUseCase(WithDrawCommand withDrawCommand){
        return ResponseEntity.ok(withDrawUseCase.withDraw(withDrawCommand));
    }

}
