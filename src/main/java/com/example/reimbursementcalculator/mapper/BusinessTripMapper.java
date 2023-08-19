package com.example.reimbursementcalculator.mapper;

import com.example.reimbursementcalculator.dto.BusinessTripDto;
import com.example.reimbursementcalculator.entity.BusinessTrip;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessTripMapper {

    public List<BusinessTripDto> mapToDtos(List<BusinessTrip> businessTrips){
        return businessTrips.stream()
                .map(p -> mapToDto(p))
                .toList();
    }


    public List<BusinessTrip> mapToEntities(List<BusinessTripDto> conferenceRoomDtos){
        return conferenceRoomDtos.stream()
                .map(p -> mapToEntity(p))
                .toList();
    }

    public BusinessTripDto mapToDto(BusinessTrip businessTrip){
        return BusinessTripDto.builder()
                .id(businessTrip.getId())
                .name(businessTrip.getName())
                .type(businessTrip.getType())
                .availability(businessTrip.isAvailability())
                .pictureFile(businessTrip.getPictureFile())
                .pricePerHour(businessTrip.getPricePerHour())
                .pricePerDay(businessTrip.getPricePerDay())
                .additionalTrip(businessTrip.getAdditionalTrip())
                .build();
    }
    public BusinessTrip mapToEntity(BusinessTripDto businessTripDto){
        return new BusinessTrip(
                businessTripDto.getId(),
                businessTripDto.getName(),
                businessTripDto.getType(),
                businessTripDto.isAvailability(),
                businessTripDto.getAdditionalTrip(),
                businessTripDto.getPictureFile(),
                businessTripDto.getPricePerHour(),
                businessTripDto.getPricePerDay(),
                businessTripDto.getReimbursementsList()
        );
    }
}
