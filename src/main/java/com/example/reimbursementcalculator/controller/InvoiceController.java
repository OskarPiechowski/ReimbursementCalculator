package com.example.reimbursementcalculator.controller;

import com.example.reimbursementcalculator.dto.InvoiceDto;
import com.example.reimbursementcalculator.frontend.RestApiClient;
import com.example.reimbursementcalculator.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@Controller
public class InvoiceController {
    private InvoiceService invoiceService;
    private RestApiClient restApiClient;

    @PostMapping("/invoice/new")
    public String addInvoice(InvoiceDto invoiceRequest) {
        invoiceService.addInvoice(invoiceRequest);
        return "redirect:/";
    }

    @GetMapping("/invoices")
    public String getAllInvoice(Model model) {
        List<InvoiceDto> invoicesDto = restApiClient.sendListProductHttpRequest();
        model.addAttribute("invoices", invoicesDto);
        return "invoices-list";
    }

    @GetMapping("/invoice/new")
    public ModelAndView getInvoice() {
        return new ModelAndView("invoice-form");
    }

    @GetMapping("/request-invoice")
    public String showInvoiceRequestForm() {
        return "request-invoice";
    }
}