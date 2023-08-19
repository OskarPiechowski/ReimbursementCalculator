package com.example.reimbursementcalculator.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationDto {

    private Long id;
    private String name;
    private String email;
    private String loginPassword;
    private String nip;
    private String address;
    private String city;
    private String postcode;

}
