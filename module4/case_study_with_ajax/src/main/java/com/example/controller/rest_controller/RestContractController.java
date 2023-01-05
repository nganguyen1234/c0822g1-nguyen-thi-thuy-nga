package com.example.controller.rest_controller;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.AttachFacilityDto;
import com.example.model.contract.ContractDetail;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
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
    @Autowired
    private IContractService contractService;

    @GetMapping("/get-attach-facility-list")
    public ResponseEntity<List<AttachFacilityDto>> getAllAttachFacility(@RequestParam("contractId") int id) {
        List<AttachFacilityDto> attachFacilityDtoList = contractDetailService.getAllAttachFacility(id);
        return new ResponseEntity<>(attachFacilityDtoList, HttpStatus.OK);
    }

    @PostMapping("/add-contract")
    public ResponseEntity<?> add(@RequestBody ContractDetail[] contractDetails) {
        contractService.addContract(contractDetails[0].getContract());
        for (int i = 0; i < contractDetails.length; i++) {
            contractDetails[i].setContract(contractDetails[0].getContract());
            contractDetailService.addContractDetail(contractDetails[i]);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
