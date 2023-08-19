package com.example.reimbursementcalculator.restService;

import com.example.reimbursementcalculator.dto.InvoiceDto;
import com.example.reimbursementcalculator.entity.BusinessTrip;
import com.example.reimbursementcalculator.entity.Invoice;
import com.example.reimbursementcalculator.entity.RegistrationExpense;
import com.example.reimbursementcalculator.exceptions.InvoiceAlreadyExistsException;
import com.example.reimbursementcalculator.mapper.InvoiceMapper;
import com.example.reimbursementcalculator.repository.BusinessTripRepository;
import com.example.reimbursementcalculator.repository.InvoiceRepository;
import com.example.reimbursementcalculator.repository.RegistrationExpenseRepository;
import com.example.reimbursementcalculator.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceRestService {

    private final RegistrationExpenseRepository registrationExpenseRepository;
    private final BusinessTripRepository businessTripRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    private final InvoiceService invoiceService;

    public InvoiceRestService(RegistrationExpenseRepository registrationExpenseRepository,
                              BusinessTripRepository businessTripRepository,
                              InvoiceRepository invoiceRepository,
                              InvoiceMapper invoiceMapper,
                              InvoiceService invoiceService) {
        this.registrationExpenseRepository = registrationExpenseRepository;
        this.businessTripRepository = businessTripRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.invoiceService = invoiceService;
    }


    public InvoiceDto createInvoice(Long registrationId) {
        Optional<RegistrationExpense> registrationOptional = registrationExpenseRepository.findById(registrationId);
        if (registrationOptional.isPresent()) {
            RegistrationExpense registrationExpense = registrationOptional.get();
            if (invoiceRepository.existsByBusinessTripId(registrationId)) {
                throw new InvoiceAlreadyExistsException("Invoice already exists for registrationExpense ID: " + registrationId);
            }
            BusinessTrip trip = registrationExpense.getBusinessTrip();


            Invoice invoice = new Invoice();
            invoice.setNumber(generateInvoiceNumber());
            invoice.setName(registrationExpense.getOrganisation().getName());
            invoice.setNip(Long.valueOf(registrationExpense.getOrganisation().getNip()));
            invoice.setAddress(registrationExpense.getOrganisation().getAddress());
            invoice.setPostcode(registrationExpense.getOrganisation().getPostcode());
            invoice.setCity(registrationExpense.getOrganisation().getCity());
            invoice.setBusinessTripId(trip.getId());
            invoice.setValue(calculateInvoiceValue(registrationExpense));
            invoice.setDate(LocalDateTime.now());
            invoice.setTrip_id(registrationId);

            Invoice savedInvoice = invoiceRepository.save(invoice);

            return invoiceMapper.mapToDto(savedInvoice);
        } else {
            return null;
        }
    }

    private String generateInvoiceNumber() {
        Instant now = Instant.now();
        long epochSecond = now.getEpochSecond();
        String formattedInstant = String.valueOf(epochSecond);
        return "INV-" + formattedInstant;
    }

    private Double calculateInvoiceValue(RegistrationExpense registration) {
        BigDecimal pricePerDay = registration.getBusinessTrip().getPricePerDay();
        LocalDate startDate = registration.getStartDate();
        LocalDate endDate = registration.getEndDate();
        LocalTime startTime = registration.getStartTime();
        LocalTime endTime = registration.getEndTime();

        if (startDate.equals(endDate)) {
            long durationInMinutes = Duration.between(startTime, endTime).toMinutes();
            double durationInHours = (double) durationInMinutes / 60;
            BigDecimal invoiceValue = pricePerDay.multiply(BigDecimal.valueOf(durationInHours));
            return invoiceValue.doubleValue();
        } else {
            long numberOfDays = ChronoUnit.DAYS.between(startDate, endDate);
            BigDecimal invoiceValue = pricePerDay.multiply(BigDecimal.valueOf(numberOfDays));
            return invoiceValue.doubleValue();
        }
    }

    public List<InvoiceDto> getAllInvoices() {
        List<InvoiceDto> invoiceDtos = invoiceMapper.mapToDtos(invoiceRepository.findAll());
        return invoiceDtos;
    }



}

