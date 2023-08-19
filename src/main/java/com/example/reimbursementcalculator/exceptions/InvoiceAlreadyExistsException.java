package com.example.reimbursementcalculator.exceptions;

public class InvoiceAlreadyExistsException extends RuntimeException {

    public InvoiceAlreadyExistsException(String message) {
        super(message);
    }
}
