package com.example.hexagonalarchitecture.application.port.in.user;

import lombok.Builder;

@Builder
public class UserDTO {
    private String status;
    private String message;

    public static UserDTO ofSuccess(String message){
        return UserDTO.builder()
            .status("Y")
            .message(message)
            .build();
    }

    public static UserDTO ofFailed(String message){
        return UserDTO.builder()
            .status("N")
            .message(message)
            .build();
    }
}
