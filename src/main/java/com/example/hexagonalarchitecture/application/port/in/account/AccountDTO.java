package com.example.hexagonalarchitecture.application.port.in.account;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountDTO {
    private String status;
    private String message;

    public static AccountDTO ofSuccess(String message){
        return AccountDTO.builder()
            .status("Y")
            .message(message)
            .build();
    }
}
