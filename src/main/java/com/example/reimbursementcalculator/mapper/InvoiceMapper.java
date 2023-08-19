package com.example.reimbursementcalculator.mapper;

import com.example.reimbursementcalculator.dto.InvoiceDto;
import com.example.reimbursementcalculator.entity.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class InvoiceMapper {

    public List<InvoiceDto> mapToDtos(List<Invoice> invoices) {
        return invoices.stream()
                .map(this::mapToDto)
                .toList();
    }


    public List<Invoice> mapToEntities(List<InvoiceDto> invoiceDtos) {
        return invoiceDtos.stream()
                .map(this::mapToEntity)
                .toList();
    }

    public InvoiceDto mapToDto(Invoice invoice) {
        return InvoiceDto.builder()
                .id(invoice.getId())
                .name(invoice.getName())
                .address(invoice.getAddress())
                .nip(invoice.getNip())
                .city(invoice.getCity())
                .date(invoice.getDate())
                .number(invoice.getNumber())
                .value(invoice.getValue())
                .postcode(invoice.getPostcode())
                .build();

    }

    public Invoice mapToEntity(InvoiceDto invoiceDto) {
        return new Invoice(invoiceDto.getId()
                ,invoiceDto.getName()
                ,invoiceDto.getAddress()
                ,invoiceDto.getNip()
                ,invoiceDto.getCity()
                ,invoiceDto.getNumber()
                ,invoiceDto.getPostcode()
                ,invoiceDto.getBusinessTripId()
                ,invoiceDto.getValue()
                ,invoiceDto.getDate()
                ,invoiceDto.getTripId());
    }
}
