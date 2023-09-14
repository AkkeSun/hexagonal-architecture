package com.example.hexagonalarchitecture.infrastructure.exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionDTO {

    private String result;
    private String date;
    private String errorCode;
    private String message;

    public ExceptionDTO(ApiException e) {
        this.result = "N";
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.errorCode = e.getApiErrorCode().errorCode();
        this.message = e.getApiErrorCode().message();
    }

    public ExceptionDTO(String message) {
        this.result = "N";
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.errorCode = "500";
        this.message = message;
    }
}
