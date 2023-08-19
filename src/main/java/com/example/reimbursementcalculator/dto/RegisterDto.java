package com.example.reimbursementcalculator.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    private Long id;

    private String name;
    private String email;
    private String loginPassword;
    private String nip;
    private String address;
    private String city;
    private String postcode;

}

