package com.example.controller.rest_controller;

import com.example.dto.contract.AddContractErrorDto;
import com.example.dto.contract.AttachFacilityDto;
import com.example.dto.contract.AttachFacilityErrorDto;
import com.example.dto.contract.ContractDetailDto;
import com.example.model.contract.*;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/contract")
@CrossOrigin("*")
public class RestContractController {
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("/get-attach-facility-list")
    public ResponseEntity<List<AttachFacilityDto>> getAllAttachFacility(@RequestParam("contractId") int id) {
        List<AttachFacilityDto> attachFacilityDtoList = contractDetailService.getAllAttachFacility(id);
        return new ResponseEntity<>(attachFacilityDtoList, HttpStatus.OK);
    }

    @PostMapping("/add-contract")
    public ResponseEntity<?> add(@Validated @RequestBody ContractDetailDto[] contractDetailDtos) {
        BindingResult contractBindingResult = new BeanPropertyBindingResult(contractDetailDtos[0].getContract(), "contract");
        contractDetailDtos[0].getContract().validate(contractDetailDtos[0].getContract(), contractBindingResult);
        List<BindingResult> contractDetailBindingResult = new ArrayList<>();
        List<AttachFacilityErrorDto> attachFacilityErrorDtos = new ArrayList<>();
        if (contractDetailDtos[0].getAttachFacility() != null) {
            for (ContractDetailDto dto : contractDetailDtos) {
                BindingResult br = new BeanPropertyBindingResult(dto, "dto");
                dto.validate(dto, br);
                if (br.hasErrors()) {
                    if (br.getFieldError("quantity") != null) {
                        String name = attachFacilityService.getNameById(dto.getAttachFacility().getId());
                        attachFacilityErrorDtos.add(new AttachFacilityErrorDto(name, "số lượng phải là số dương"));
                    }
                }
                contractDetailBindingResult.add(br);
            }
        }

        AddContractErrorDto responseDto = null;
        if (contractBindingResult.hasErrors()) {
            responseDto = new AddContractErrorDto();
            if (contractBindingResult.getFieldError("startDate") != null) {
                responseDto.setStartDate(contractBindingResult.getFieldError("startDate").getDefaultMessage());
            }
            if (contractBindingResult.getFieldError("endDate") != null) {
                responseDto.setEndDate(contractBindingResult.getFieldError("endDate").getDefaultMessage());
            }
            if (contractBindingResult.getFieldError("deposit") != null) {
                responseDto.setDeposit("tiền đặt cọc phải là số dương");
            }
            if (!contractDetailBindingResult.isEmpty()) {
                responseDto.setAttachFacilityErrorDtos(attachFacilityErrorDtos);
            }
        }

        if (responseDto != null) {
            // has error
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDetailDtos[0].getContract(), contract);
        contractService.addContract(contract);
        for (int i = 0; i < contractDetailDtos.length; i++) {
//            contractDetailDtos[i].setContract(contractDetailDtos[0].getContract());
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDtos[i], contractDetail);
            contractDetail.setContract(contract);
            contractDetailService.addContractDetail(contractDetail);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
