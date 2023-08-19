package com.example.reimbursementcalculator.restService;

import com.example.reimbursementcalculator.exceptions.InvoiceAlreadyExistsException;
import com.example.reimbursementcalculator.repository.RegistrationExpenseRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationRestService {

    private final RegistrationExpenseRepository registrationExpenseRepository;


    public ReservationRestService(RegistrationExpenseRepository registrationExpenseRepository) {
        this.registrationExpenseRepository = registrationExpenseRepository;
    }

    public void checkInvoiceExistenceByReservationId(Long reservationId) {
        if (registrationExpenseRepository.existsById(reservationId)) {
            throw new InvoiceAlreadyExistsException("Invoice already exists for reservation ID: " + reservationId);
        }
    }

}

