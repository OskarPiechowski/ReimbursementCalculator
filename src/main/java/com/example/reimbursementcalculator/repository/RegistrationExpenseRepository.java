package com.example.reimbursementcalculator.repository;

import com.example.reimbursementcalculator.entity.RegistrationExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationExpenseRepository extends JpaRepository<RegistrationExpense,Long> {

    RegistrationExpense findById(long id);

    boolean existsById(int id);

    void deleteById(int id);

    void getReservationById(long id);
}
