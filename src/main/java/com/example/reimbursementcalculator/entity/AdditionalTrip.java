package com.example.reimbursementcalculator.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "additional_trip")
@Builder
@EqualsAndHashCode
public class AdditionalTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tripName;

    private int distance;

    private Integer numberOfDays = null;

    @Column(name = "price_per_mileage")
    private BigDecimal pricePerMileage;

    @Column(name = "price_per_trip")
    private BigDecimal pricePerTrip;

}
