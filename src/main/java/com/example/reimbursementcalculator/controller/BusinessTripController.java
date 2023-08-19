package com.example.reimbursementcalculator.controller;

import com.example.reimbursementcalculator.dto.BusinessTripDto;
import com.example.reimbursementcalculator.service.BusinessTripService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class BusinessTripController {

    private BusinessTripService businessTripService;

    @GetMapping("/list")
    public ResponseEntity<List<BusinessTripDto>> findAllBusinessTrips(){
        return ResponseEntity.ok().body(businessTripService.getBusinessTrips());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void createRoom(@RequestBody BusinessTripDto businessTripDto) {
        businessTripService.addBusinessTrip(businessTripDto);
    }

    @GetMapping("/{id}")
    public BusinessTripDto findBusinessTripById(@PathVariable Long id){
        BusinessTripDto businessTripById = businessTripService.getBusinessTripById(id);
        return businessTripById;
    }
    @DeleteMapping("/del/{id}")
    public void deleteBusinessTrip(@PathVariable Long id){
        businessTripService.remove(id);
    }

}

