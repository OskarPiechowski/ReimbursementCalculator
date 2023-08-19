package com.example.reimbursementcalculator.service;

import com.example.reimbursementcalculator.dto.InvoiceDto;
import com.example.reimbursementcalculator.entity.Invoice;
import com.example.reimbursementcalculator.mapper.InvoiceMapper;
import com.example.reimbursementcalculator.repository.InvoiceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceService {
        private InvoiceRepository invoiceRepository;
        private InvoiceMapper invoiceMapper;

        public void addInvoice(InvoiceDto request) {
                Invoice invoice = invoiceMapper.mapToEntity(request);
                invoiceRepository.save(invoice);
        }

        public List<Invoice> findAllInvoices() {

                return invoiceRepository.findAll();

        }
}
