package com.example.reimbursementcalculator.mapper;


import com.example.reimbursementcalculator.dto.RegistrationExpenseDto;
import com.example.reimbursementcalculator.entity.RegistrationExpense;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class registrationExpenceMapper {



    public List<RegistrationExpenseDto> mapToDtos(List<RegistrationExpense> registrationExpenses){
        return registrationExpenses.stream()
                .map(p -> mapToDto(p))
                .toList();
    }


    public List<RegistrationExpense> mapToEntities(List<RegistrationExpenseDto> roomReservationDtos){
        return roomReservationDtos.stream()
                .map(p -> mapToEntity(p))
                .toList();
    }

    public RegistrationExpenseDto mapToDto(RegistrationExpense registrationExpense){
        RegistrationExpenseDto registrationExpenseDto = new RegistrationExpenseDto();
        registrationExpenseDto.setId(registrationExpense.getId());
        registrationExpenseDto.setStartDate(registrationExpense.getStartDate());
        registrationExpenseDto.setBusinessTripId(registrationExpense.getBusinessTrip().getId());
        return registrationExpenseDto;
    }
    public RegistrationExpense mapToEntity(RegistrationExpenseDto roomReservationDto){
        RegistrationExpense registrationExpense = new RegistrationExpense();
        registrationExpense.setId(roomReservationDto.getId());
        registrationExpense.setStartDate(roomReservationDto.getStartDate());
        registrationExpense.setStartTime(roomReservationDto.getStartTime());
        registrationExpense.setEndDate(roomReservationDto.getEndDate());
        registrationExpense.setStartTime(roomReservationDto.getEndTime());
        return registrationExpense;
    }
}
