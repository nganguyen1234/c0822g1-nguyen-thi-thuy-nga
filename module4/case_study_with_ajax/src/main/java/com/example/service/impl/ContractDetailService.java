package com.example.service.impl;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.AttachFacilityDto;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.repository.contract.IContractDetailRepository;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractService contractService;

    List<ContractDetail> getAllContractDetails() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<AttachFacilityDto> getAllAttachFacility(int contractId) {
        List<AttachFacilityDto> attachFacilityDtoList = new ArrayList<>();
        List<ContractDetail> contractDetailList = getAllContractDetails();
        for (ContractDetail ct : contractDetailList) {
            if (ct.getContract().getId() == contractId) {
                AttachFacilityDto attachFacilityDto = new AttachFacilityDto();
                BeanUtils.copyProperties(ct.getAttachFacility(), attachFacilityDto);
                attachFacilityDto.setQuantity(ct.getQuantity());
                attachFacilityDtoList.add(attachFacilityDto);
            }
        }
        return attachFacilityDtoList;
    }

    @Override
    public boolean addContractDetail(ContractDetail contractDetail) {
        if (!contractService.isExist(contractDetail.getContract())) {
            return false;
        }
        try {
            contractDetailRepository.save(contractDetail);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

}
