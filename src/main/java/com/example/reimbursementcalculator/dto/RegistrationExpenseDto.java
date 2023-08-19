package com.example.reimbursementcalculator.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class RegistrationExpenseDto {

    private long id;
    private String organisationName;
    private long businessTripId;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;
    private boolean isTripCancelled;

}
