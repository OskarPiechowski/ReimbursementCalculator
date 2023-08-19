package com.example.reimbursementcalculator.controller;

import com.example.reimbursementcalculator.service.OrganisationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authorisation")
public class AuthorizationController {

    private OrganisationService organisationService;

    public AuthorizationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }
}
