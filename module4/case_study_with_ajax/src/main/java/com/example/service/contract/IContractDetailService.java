package com.example.service.contract;

import com.example.model.contract.AttachFacility;

import java.util.Map;

public interface IContractDetailService {
    Map<AttachFacility, Integer> getAllAttachFacility(int contractId);
}
