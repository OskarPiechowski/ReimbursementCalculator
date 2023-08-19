package com.example.reimbursementcalculator.service;

import com.example.reimbursementcalculator.dto.BusinessTripDto;
import com.example.reimbursementcalculator.entity.BusinessTrip;
import com.example.reimbursementcalculator.mapper.BusinessTripMapper;
import com.example.reimbursementcalculator.repository.BusinessTripRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class BusinessTripService {

    private BusinessTripRepository businessTripRepository;
    private BusinessTripMapper businessTripMapper;

    public void addBusinessTrip(BusinessTripDto businessTripDto){
        BusinessTrip businessTrip = businessTripMapper.mapToEntity(businessTripDto);
        businessTripRepository.save(businessTrip);
    }

    public List<BusinessTripDto> getBusinessTrips(){
        List<BusinessTripDto> businessTripDtos;
        List<BusinessTrip> businessTrips = businessTripRepository.findAll();
        businessTripDtos = businessTripMapper.mapToDtos(businessTrips);
        return businessTripDtos;
    }

    public BusinessTripDto getBusinessTripById(Long id) {
        BusinessTrip businessTrip = businessTripRepository.findById(id).orElseThrow(()->new NullPointerException("Business Trip does not exist"));

        return businessTripMapper.mapToDto(businessTrip);
    }

    public void remove(Long id) {
        businessTripRepository.deleteById(id);
    }

    public List<BusinessTripDto> getAllBusinessTrips() {
        List<BusinessTrip> businessTrips = businessTripRepository.findAll();
        List<BusinessTripDto> businessTripDtos = new ArrayList<>();
        for (BusinessTrip businessTrip : businessTrips) {
            businessTripDtos.add(businessTripMapper.mapToDto(businessTrip));
        }
        return businessTripDtos;
    }

    public List<BusinessTripDto> getAllBusinessTripsDtos() {
        return getAllBusinessTrips();
    }

    public BusinessTrip getBusinessTripById(long id) {
        BusinessTrip businessTrip = businessTripRepository.findById(id).orElseThrow(()->new NullPointerException("Business Trip does not exist"));
        return businessTrip;
    }
}
