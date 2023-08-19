package com.example.reimbursementcalculator.repository;

import com.example.reimbursementcalculator.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    List<Invoice> findAll();

    Invoice save(Invoice invoice);

    boolean existsByBusinessTripId(Long businessTripId);

}
