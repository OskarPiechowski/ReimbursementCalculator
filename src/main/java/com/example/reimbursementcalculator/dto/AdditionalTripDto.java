package com.example.reimbursementcalculator.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalTripDto {
    private long id;

    private String tripName;
    private int distance;
    private Integer numberOfDays = null;
    @Column(name = "price_per_mileage")
    private BigDecimal pricePerHour;

    @Column(name = "price_per_trip")
    private BigDecimal pricePerDay;
}
