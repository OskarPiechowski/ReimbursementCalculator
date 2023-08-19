package com.example.reimbursementcalculator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "business_trips")
@JsonIgnoreProperties("businessTripList")
public class BusinessTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int type;
    private boolean availability;


    @ManyToOne
    @JoinColumn(name = "id_additional_trip")
    public AdditionalTrip additionalTrip;
    private String pictureFile;
    private BigDecimal pricePerHour;
    private BigDecimal pricePerDay;
    @OneToMany(mappedBy = "businessTrip", fetch = FetchType.EAGER)
    private List<RegistrationExpense> registrationExpenseList = new ArrayList<>();
}
