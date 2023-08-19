package com.example.reimbursementcalculator.frontend;


import com.example.reimbursementcalculator.dto.InvoiceDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class RestApiClient {

    public List<InvoiceDto> sendListProductHttpRequest() {
        RestTemplate restTemplate = new RestTemplate();
        InvoiceDto[] responseDto = restTemplate.getForObject("http://localhost:8080/api/invoices", InvoiceDto[].class);
        return Arrays.asList(responseDto);
    }
}
