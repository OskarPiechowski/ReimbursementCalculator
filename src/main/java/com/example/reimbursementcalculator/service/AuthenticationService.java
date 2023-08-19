package com.example.reimbursementcalculator.service;

import com.example.reimbursementcalculator.entity.Organisation;
import com.example.reimbursementcalculator.repository.OrganisationRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private OrganisationRepository organisationRepository;

    public AuthenticationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    public Optional<Organisation> selectLoggedOrganisation() {
        Object securityContextHolder = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (securityContextHolder instanceof User) {
            User user = (User) securityContextHolder;
            Optional <Organisation> loggedOrganisation = organisationRepository.findByName(user.getUsername());
            return loggedOrganisation;
        } else {
            return Optional.empty();
        }
    }
}
