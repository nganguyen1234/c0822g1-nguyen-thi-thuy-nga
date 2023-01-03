package com.example.controller.rest_controller;

import com.example.model.contract.AttachFacility;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/contract")
@CrossOrigin("*")
public class RestContractController {
    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/get-attach-facility-list")
    public ResponseEntity<Map<AttachFacility, Integer>> getAllAttachFacility(@RequestParam("contractId") int id) {
        Map<AttachFacility, Integer> attachFacilityMap = contractDetailService.getAllAttachFacility(id);
        return new ResponseEntity<>(attachFacilityMap, HttpStatus.OK);
    }
}
