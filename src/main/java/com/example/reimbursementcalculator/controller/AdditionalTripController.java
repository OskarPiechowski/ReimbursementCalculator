package com.example.reimbursementcalculator.controller;

import com.example.reimbursementcalculator.dto.AdditionalTripDto;

import com.example.reimbursementcalculator.entity.Organisation;
import com.example.reimbursementcalculator.service.AdditionalTripService;
import com.example.reimbursementcalculator.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class AdditionalTripController {

    private AdditionalTripService additionalTripService;
    private AuthenticationService authenticationService;
    @GetMapping("/add-trip")
    public String getPage() {
        return "add-additional-trip.html";
    }

    @PostMapping("/add-trip")
    public String createAdditionalTrip(AdditionalTripDto additionalTripDto, Model model) {
        System.out.println(additionalTripDto);
        additionalTripService.addAdditionalTrip(additionalTripDto);
        model.addAttribute("message", "trip added");
        return "add-additional-trip.html";
    }
    @GetMapping("/additional-trip")
    public String getAllAdditionalTrips(Model model) {
        boolean logged = authenticationService.selectLoggedOrganisation().isPresent();
        Optional<Organisation> loggedOrganisation = authenticationService.selectLoggedOrganisation();
        Organisation organisation = loggedOrganisation.get();
        System.out.println(logged);
        System.out.println(organisation);
        List<AdditionalTripDto> additionalTripDtos = additionalTripService.findAllTrips();
        model.addAttribute("trips", additionalTripDtos);
        return "additional-trip-list";
    }

    @PostMapping("/choose-trip")
    public String choose(AdditionalTripDto additionalTripDto, Model model) {
        model.addAttribute("trip", additionalTripDto);
        System.out.println("test");
        System.out.println(additionalTripDto);
        System.out.println("test");
        return "main-page";
    }
}
