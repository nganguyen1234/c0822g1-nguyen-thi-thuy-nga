package com.example.service.impl;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.repository.contract.IContractDetailRepository;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
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

    List<ContractDetail> getAllContractDetails() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Map<AttachFacility, Integer> getAllAttachFacility(int contractId) {
        Map<AttachFacility, Integer> attachFacilityMap = new HashMap<>();
        List<ContractDetail> contractDetailList = getAllContractDetails();
        for (ContractDetail ct : contractDetailList) {
            if (ct.getContract().getId() == contractId) {
                attachFacilityMap.put(ct.getAttachFacility(), ct.getQuantity());
            }
        }
        return attachFacilityMap;
    }

}
