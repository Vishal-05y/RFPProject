package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    private String phoneNumber;
    private String userName;
    private String oneTimePassword;
    //private String userType = "customer"; // Default value set to worker
}
