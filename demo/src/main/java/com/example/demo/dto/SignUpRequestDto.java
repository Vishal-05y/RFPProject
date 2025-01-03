package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    private String phoneNumber="9390906408";
    private String userName="Vishal";
    private String oneTimePassword;
}
