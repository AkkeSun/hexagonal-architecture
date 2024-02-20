package com.example.hexagonalarchitecture.account.adapter.in.deposit;

import com.example.hexagonalarchitecture.account.application.port.in.deposit.DepositUseCase;
import com.example.hexagonalarchitecture.account.application.service.deposit.DepositServiceResponse;
import com.example.hexagonalarchitecture.global.response.ApiResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
class DepositController {

    private final DepositUseCase depositUseCase;

    @PutMapping("/deposit")
    ApiResponse<DepositResponse> deposit(
        @RequestBody @Valid DepositRequest request) {
        DepositServiceResponse response = depositUseCase.deposit(request.toCommand());
        return ApiResponse.ok(new DepositResponse().of(response));
    }
}
