package com.example.demo.dto;

import com.example.demo.dto.OtpStatus;

public class SignUpResponseDto {
    private OtpStatus status;
    private String message;

    // Constructor
    public SignUpResponseDto(OtpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters and Setters
    public OtpStatus getStatus() {
        return status;
    }

    public void setStatus(OtpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


