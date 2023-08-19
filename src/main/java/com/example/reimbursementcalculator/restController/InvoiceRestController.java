package com.example.reimbursementcalculator.restController;

import com.example.reimbursementcalculator.dto.InvoiceDto;
import com.example.reimbursementcalculator.entity.Invoice;
import com.example.reimbursementcalculator.restService.InvoiceRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceRestController {

    private final InvoiceRestService invoiceRestService;

    public InvoiceRestController(InvoiceRestService invoiceRestService) {
        this.invoiceRestService = invoiceRestService;
    }

    @GetMapping
    public List<InvoiceDto> getInvoiceApi(){
        return invoiceRestService.getAllInvoices();
    }

    @GetMapping("/a")
    public Invoice getInvoice(){
        Invoice invoice = new Invoice();
        return invoice;
    }

    @PostMapping("/{registrationId}")
    public ResponseEntity<InvoiceDto> createInvoice(@PathVariable("registrationId") Long reservationId) {
        InvoiceDto invoiceDto = invoiceRestService.createInvoice(reservationId);
        if (invoiceDto != null) {
            return ResponseEntity.ok(invoiceDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
