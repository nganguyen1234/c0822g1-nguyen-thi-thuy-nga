package com.example.controller.rest_controller;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.AttachFacilityDto;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/contract")
@CrossOrigin("*")
public class RestContractController {
    @Autowired
    private IContractDetailService contractDetailService;



    @GetMapping("/get-attach-facility-list")
    public ResponseEntity<List<AttachFacilityDto>> getAllAttachFacility(@RequestParam("contractId") int id) {
        List<AttachFacilityDto> attachFacilityDtoList = contractDetailService.getAllAttachFacility(id);
        return new ResponseEntity<>(attachFacilityDtoList, HttpStatus.OK);
    }
}
