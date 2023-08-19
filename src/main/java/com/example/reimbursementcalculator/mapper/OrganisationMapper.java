package com.example.reimbursementcalculator.mapper;

import com.example.reimbursementcalculator.dto.OrganisationDto;
import com.example.reimbursementcalculator.entity.Organisation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganisationMapper {

    private PasswordEncoder passwordEncoder;

    public OrganisationMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public List<OrganisationDto> mapToDtos(List<Organisation> organisations){
    return organisations.stream()
            .map(this::mapToDto)
            .toList();
}


public List<Organisation> mapToEntities(List<OrganisationDto> organisationDtos){
    return organisationDtos.stream()
            .map(this::mapToEntity)
            .toList();
}

public OrganisationDto mapToDto(Organisation organisation){
return OrganisationDto.builder()
        .id(organisation.getId())
        .name(organisation.getName())
        .email(organisation.getEmail())
        .loginPassword(organisation.getLoginPassword())
        .nip(organisation.getNip())
        .address(organisation.getAddress())
        .city(organisation.getCity())
        .postcode(organisation.getPostcode())
        .build();
}
public Organisation mapToEntity(OrganisationDto organisationDto){
return new Organisation(
        organisationDto.getId(),
        organisationDto.getName(),
        organisationDto.getEmail(),
        passwordEncoder.encode(organisationDto.getLoginPassword()),
        organisationDto.getNip(),
        organisationDto.getAddress(),
        organisationDto.getCity(),
        organisationDto.getPostcode());
}
}