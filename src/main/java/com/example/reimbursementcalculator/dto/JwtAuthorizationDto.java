package com.example.reimbursementcalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthorizationDto {

    private String accessToken;

    private String tokenType = "Bearer";
}
