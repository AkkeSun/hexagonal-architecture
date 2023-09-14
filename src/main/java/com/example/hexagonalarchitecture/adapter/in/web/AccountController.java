package com.example.hexagonalarchitecture.adapter.in.web;

import com.example.hexagonalarchitecture.application.port.in.account.AccountCreateCommand;
import com.example.hexagonalarchitecture.application.port.in.account.AccountCreateUseCase;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountSearchUseCase searchUseCase;
    private final AccountCreateUseCase createUseCase;
    private final DepositUseCase depositUseCase;
    private final WithDrawUseCase withDrawUseCase;

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount (AccountCreateCommand command) {
        return ResponseEntity.ok(createUseCase.createAccount(command));
    }

    @PostMapping("/search")
    public ResponseEntity<AccountDTO> searchAccount (AccountSearchCommand command) {
        return ResponseEntity.ok(searchUseCase.getAccount(command));
    }

    @PutMapping("/deposit")
    public ResponseEntity<AccountDTO> deposit(DepositCommand command){
        return ResponseEntity.ok(depositUseCase.deposit(command));
    }

    @PutMapping("/withDraw")
    public ResponseEntity<AccountDTO> withDrawUseCase(WithDrawCommand command){
        return ResponseEntity.ok(withDrawUseCase.withDraw(command));
    }

}
