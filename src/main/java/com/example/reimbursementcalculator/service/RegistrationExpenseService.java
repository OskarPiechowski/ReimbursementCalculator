package com.example.reimbursementcalculator.service;

import com.example.reimbursementcalculator.dto.RegistrationExpenseDto;
import com.example.reimbursementcalculator.entity.BusinessTrip;
import com.example.reimbursementcalculator.entity.Organisation;
import com.example.reimbursementcalculator.entity.RegistrationExpense;
import com.example.reimbursementcalculator.repository.RegistrationExpenseRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RegistrationExpenseService {
    private final RegistrationExpenseRepository registrationExpenseRepository;
    private final  AuthenticationService authenticationService;
    private final BusinessTripService businessTripService;

    private final com.example.reimbursementcalculator.mapper.registrationExpenceMapper registrationExpenceMapper;

    public List<RegistrationExpense> findAll() {
        return registrationExpenseRepository.findAll();
    }

    public RegistrationExpense getById(long id) {
        RegistrationExpense registrationExpense = registrationExpenseRepository.findById(id);
        return registrationExpense;
    }

    public void add(RegistrationExpense registrationExpense) {
        registrationExpenseRepository.save(registrationExpense);
    }

    public boolean existsById(int id) {
        return registrationExpenseRepository.existsById(id);
    }

    public void deleteById(int id) {
        registrationExpenseRepository.deleteById(id);
    }

    public void createRegistration(RegistrationExpense registrationExpense) {
    }

    public void setRegistrationExpense(long tripId, RegistrationExpenseDto registrationExpenseDto) {
        Optional<Organisation> loggedOrganisation = authenticationService.selectLoggedOrganisation();
        Organisation organisation = loggedOrganisation.get();
        RegistrationExpense registrationExpense = registrationExpenceMapper.mapToEntity(registrationExpenseDto);
        BusinessTrip businessTrip = businessTripService.getBusinessTripById(tripId);
        registrationExpense.setBusinessTrip(businessTrip);
        registrationExpense.setOrganisation(organisation);
        add(registrationExpense);
    }


}
