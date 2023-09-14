package com.example.hexagonalarchitecture.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String userName;
    private String jumin;
    private String phoneNumber;
}
