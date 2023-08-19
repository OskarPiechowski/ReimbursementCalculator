package com.example.reimbursementcalculator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Builder
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="invoice_id")
    private long id;
    @Column(name="invoice_number")
    private String number;
    @Column(name="invoice_organisation_name")
    private String name;
    @Column(name="invoice_organisation_nip")
    private Long nip;
    @Column(name="invoice_organisation_address")
    private String address;
    @Column(name="invoice_organisation_postcode")
    private String postcode;
    @Column(name="invoice_organisation_city")
    private String city;
    @Column(name="trip_id")
    private Long trip_id;
    @Column(name="invoice_value")
    private Double value;
    @Column(name="invoice_Date")
    private LocalDateTime date;
    @Column(name="businessTrip_id")
    private Long businessTripId;


    public Invoice(String name, Long nip) {
        this.name = name;
        this.nip = nip;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", nip=" + nip +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", trip_id=" + trip_id +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
