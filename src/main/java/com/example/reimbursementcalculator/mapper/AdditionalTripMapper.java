package com.example.reimbursementcalculator.mapper;

import com.example.reimbursementcalculator.dto.AdditionalTripDto;
import com.example.reimbursementcalculator.entity.AdditionalTrip;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdditionalTripMapper {
    public List<AdditionalTripDto> mapToDtos(List<AdditionalTrip> additionalEquipments){
        return additionalEquipments.stream()
                .map(p -> mapToDto(p))
                .toList();
    }


    public List<AdditionalTrip> mapToEntities(List<AdditionalTripDto> additionalEquipmentDtos){
        return additionalEquipmentDtos.stream()
                .map(p -> mapToEntity(p))
                .toList();
    }

    public AdditionalTripDto mapToDto(AdditionalTrip additionalTrip){
        return AdditionalTripDto.builder()
                .id(additionalTrip.getId())
                .tripName(additionalTrip.getTripName())
                .distance(additionalTrip.getDistance())
                .numberOfDays(additionalTrip.getNumberOfDays())
                .pricePerDay(additionalTrip.getPricePerTrip())
                .build();
    }
    public AdditionalTrip mapToEntity(AdditionalTripDto additionalEquipmentDto){
        return new AdditionalTrip(
                additionalEquipmentDto.getId(),
                additionalEquipmentDto.getTripName(),
                additionalEquipmentDto.getDistance(),
                additionalEquipmentDto.getNumberOfDays(),
                additionalEquipmentDto.getPricePerHour(),
                additionalEquipmentDto.getPricePerDay());
    }
}
