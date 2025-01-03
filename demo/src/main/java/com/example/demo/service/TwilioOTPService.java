package com.example.demo.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.TwilioConfig;
import com.example.demo.dto.OtpStatus;
import com.example.demo.dto.SignUpRequestDto;
import com.example.demo.dto.SignUpResponseDto;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import reactor.core.publisher.Mono;

@Service
public class TwilioOTPService {

    @Autowired
    private TwilioConfig twilioConfig;

    private Map<String, String> otpMap = new HashMap<>();

    public Mono<SignUpResponseDto> sendOTPForSignUp(SignUpRequestDto signUpRequestDto) {
        SignUpResponseDto signUpResponseDto=null;

        try {
            PhoneNumber to = new PhoneNumber(signUpRequestDto.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String otp = generateOTP();

            String otpMessage = "Dear Customer, Your OTP is: " + otp + ". Thank You.";
            Message.creator(to, from, otpMessage).create();

            // Store OTP for the user
            otpMap.put(signUpRequestDto.getUserName(), otp);

            signUpResponseDto = new SignUpResponseDto(OtpStatus.DELIVERED, otpMessage);
        } catch (Exception ex) {
            signUpResponseDto = new SignUpResponseDto(OtpStatus.FAILED, ex.getMessage());
        }

        return Mono.just(signUpResponseDto);
    }

    public Mono<String> validateOTP(String userInputOtp, String userName) {
        String storedOtp = otpMap.get(userName);

        if (storedOtp != null && storedOtp.equals(userInputOtp)) {
            otpMap.remove(userName,userInputOtp); // OTP is valid, remove it from the map
            return Mono.just("Valid OTP.");
        } else {
            return Mono.error(new IllegalArgumentException("Invalid OTP. Please retry!"));
        }
    }

    private String generateOTP() {
        return new DecimalFormat("000000").format(new Random().nextInt(999999));
    }
}
