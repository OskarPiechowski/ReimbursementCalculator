package com.example.reimbursementcalculator.controller;

import com.example.reimbursementcalculator.dto.BusinessTripDto;
import com.example.reimbursementcalculator.dto.RegistrationExpenseDto;
import com.example.reimbursementcalculator.entity.BusinessTrip;
import com.example.reimbursementcalculator.entity.Organisation;
import com.example.reimbursementcalculator.entity.RegistrationExpense;
import com.example.reimbursementcalculator.service.AuthenticationService;
import com.example.reimbursementcalculator.service.BusinessTripService;
import com.example.reimbursementcalculator.service.RegistrationExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@AllArgsConstructor
@RequestMapping
public class RegistrationExpenseController {

    @Autowired
    @Qualifier("registrationExpenseService")
    private RegistrationExpenseService registrationExpenseService;
    private BusinessTripService businessTripService;

    private AuthenticationController authenticationController;

    private AuthenticationService authenticationService;

    @GetMapping("/registrations")
    public String getRegistrationExpenses(Model model) {
        List<RegistrationExpense> registrationExpenseList = registrationExpenseService.findAll();
        model.addAttribute("registrations", registrationExpenseList);
        return "registrations-list";
    }


    @PostMapping("/registrations")
    public String createReservation(@ModelAttribute("registration") RegistrationExpenseDto registrationExpenseDto,
                                    @RequestParam("tripId") long tripId) {
        registrationExpenseService.setRegistrationExpense(tripId, registrationExpenseDto);
        return "redirect:/registrations";
    }

    @GetMapping("/registrations/new")
    public String getRegistrationForm(@RequestParam("tripId") Long tripId, Model model) {
        List<BusinessTripDto> tripDtos = businessTripService.getAllBusinessTrips();
        Optional<Organisation> loggedOrganisation = authenticationService.selectLoggedOrganisation();
        Organisation organisation = loggedOrganisation.get();
        model.addAttribute("tripDtos", tripDtos);
        model.addAttribute("registration", new RegistrationExpense());
        model.addAttribute("tripId", tripId);
        model.addAttribute("organisationName", organisation);
        System.out.println("!!!!!!!!!!!!!!" + tripId + "!!!!!!!!!!!!!!");
        int x = tripId.intValue() - 1;
        System.out.println(tripDtos.get(x).getName());
        return "registration-form";
    }

    @GetMapping("/api")
    public String redirectToApi() {
        return "redirect:/api/registrations";
    }
}