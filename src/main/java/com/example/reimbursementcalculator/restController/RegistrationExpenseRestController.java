package com.example.reimbursementcalculator.restController;

import com.example.reimbursementcalculator.entity.RegistrationExpense;
import com.example.reimbursementcalculator.service.RegistrationExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationExpenseRestController {

    private final RegistrationExpenseService registrationExpenseService;

    public RegistrationExpenseRestController(RegistrationExpenseService registrationExpenseService) {
        this.registrationExpenseService = registrationExpenseService;
    }

    @GetMapping
    public List<RegistrationExpense> getRegistrationExpenseApi() {
        return registrationExpenseService.findAll();
    }


}

