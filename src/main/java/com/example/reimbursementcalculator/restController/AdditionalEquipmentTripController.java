package com.example.reimbursementcalculator.restController;

import com.example.reimbursementcalculator.controller.AdditionalTripController;
import com.example.reimbursementcalculator.dto.AdditionalTripDto;
import com.example.reimbursementcalculator.service.AdditionalTripService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("api")
public class AdditionalEquipmentTripController {

    private static final Logger LOG = LoggerFactory.getLogger(AdditionalTripController.class);
    private AdditionalTripService additionalTripService;

    @GetMapping("/additional-trips")
    public ResponseEntity<List<AdditionalTripDto>> getAdditionalTrips() {
        LOG.info("Request to list all additional trips has been received");
        return ResponseEntity.ok().body(additionalTripService.findAllTrips());
    }

    @PostMapping("/add-trip")
    void createProblem(@RequestBody AdditionalTripDto additionalTripDto){
        LOG.info("Request to add a new additional equipment has been received");
        additionalTripService.addAdditionalTrip(additionalTripDto);
    }
}
