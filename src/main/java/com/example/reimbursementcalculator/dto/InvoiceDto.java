package com.example.reimbursementcalculator.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

    @Column(unique = true)
    private long id;
    private String number;
    private String name;
    private Long nip;

    private String address;

    private String postcode;

    private String city;

    private Long tripId;

    private Double value;

    private LocalDateTime date;

    private Long businessTripId;

    public InvoiceDto(String name, Long nip) {
        this.name = name;
        this.nip = nip;
    }


    @Override
    public String toString() {
        return "InvoiceDto{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", trip_id=" + tripId +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
