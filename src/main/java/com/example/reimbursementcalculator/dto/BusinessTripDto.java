package com.example.reimbursementcalculator.dto;

import com.example.reimbursementcalculator.entity.AdditionalTrip;
import com.example.reimbursementcalculator.entity.RegistrationExpense;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BusinessTripDto {

        private long id;
        private String name;
        private int type;
        private boolean availability;

        private AdditionalTrip additionalTrip;
        private String pictureFile;
        private BigDecimal pricePerHour;
        private BigDecimal pricePerDay;
        private List<RegistrationExpense> reimbursementsList = new ArrayList<>();
}
