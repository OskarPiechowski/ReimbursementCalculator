package com.example.reimbursementcalculator.controller;

import com.example.reimbursementcalculator.dto.OrganisationDto;
import com.example.reimbursementcalculator.service.OrganisationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AuthenticationController {

    private final OrganisationService organisationService;

    public AuthenticationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @GetMapping("/")
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView("main-page.html");
        return modelAndView;
    }
    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        OrganisationDto organisationDto = new OrganisationDto();
        ModelAndView modelAndView = new ModelAndView("register.html");
        modelAndView.addObject("organisationDto", organisationDto);
        return modelAndView;
    }
    @PostMapping("/register")
    public ModelAndView createCustomer(@ModelAttribute("organisationDto") OrganisationDto organisationDto) {
        System.out.println("!!!!!" + organisationDto);
        organisationService.addOrganisation(organisationDto);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "login";
    }

    @GetMapping("/logout")
    public RedirectView getLogoutPage() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");
        return redirectView;
    }
}
