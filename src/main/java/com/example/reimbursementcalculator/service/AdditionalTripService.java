package com.example.reimbursementcalculator.service;

import com.example.reimbursementcalculator.dto.AdditionalTripDto;
import com.example.reimbursementcalculator.dto.BusinessTripDto;
import com.example.reimbursementcalculator.entity.AdditionalTrip;
import com.example.reimbursementcalculator.mapper.AdditionalTripMapper;
import com.example.reimbursementcalculator.repository.AdditionalTripRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AdditionalTripService {

    private AdditionalTripRepository additionalTripRepository;
    private AdditionalTripMapper additionalTripMapper;

    public void addAdditionalTrip(AdditionalTripDto additionalTripDto){
        AdditionalTrip additionalTrip = additionalTripMapper.mapToEntity(additionalTripDto);
        additionalTripRepository.save(additionalTrip);
    }
    public void addAdditionalTripToBusinessTrip(){
        BusinessTripDto businessTripDto = new BusinessTripDto();
        AdditionalTrip additionalTrip = new AdditionalTrip();
        AdditionalTripDto additionalTripDto = additionalTripMapper.mapToDto(additionalTripRepository.findById(1L).orElseThrow(()-> new NullPointerException()));
        businessTripDto.setAdditionalTrip(additionalTrip);
    }

    public List<AdditionalTripDto> findAllTrips() {
        List<AdditionalTrip> additionalTrips = additionalTripRepository.findAll();
        List<AdditionalTripDto> additionalTripDtos = new ArrayList<>();
        for (AdditionalTrip additionalTrip : additionalTrips) {
            additionalTripDtos.add(additionalTripMapper.mapToDto(additionalTrip));
        }
        return additionalTripDtos;
    }
}
