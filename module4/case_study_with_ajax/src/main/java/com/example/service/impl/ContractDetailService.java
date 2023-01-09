package com.example.service.impl;

import com.example.dto.contract.AttachFacilityDto;
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
import java.util.List;

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
    public boolean addContractDetail(ContractDetail newContractDetail) {
        if (!contractService.isExist(newContractDetail.getContract())) {
            return false;
        }
        List<ContractDetail> contractDetailList = getAllContractDetails();
        int contractId;
        int attachFacilityId;
        for (ContractDetail contractDetail : contractDetailList) {
            contractId = contractDetail.getContract().getId();
            attachFacilityId = contractDetail.getAttachFacility().getId();
            if (contractId == newContractDetail.getContract().getId() && attachFacilityId == newContractDetail.getAttachFacility().getId()) {
                newContractDetail.setId(contractDetail.getId());
                newContractDetail.setQuantity(contractDetail.getQuantity() + newContractDetail.getQuantity());
            }
        }
        try {
            contractDetailRepository.save(newContractDetail);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

}
