package com.example.reimbursementcalculator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reimbursement")
@Builder
@EqualsAndHashCode
public class RegistrationExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;


    @ManyToOne
    @JoinColumn(name = "Trip_id")
    private BusinessTrip businessTrip;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "end_time")
    private LocalTime endTime;


    @Column(name = "is_registration_cancelled")
    private boolean isRegistrationCancelled;

}
