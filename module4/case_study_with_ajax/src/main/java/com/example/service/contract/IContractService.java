package com.example.service.contract;

import com.example.model.contract.Contract;
import com.example.model.contract.ContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> getAllContracts();
    Page<Contract> getAllContracts(Pageable pageable);
    Page<ContractDto> getAllContractDto(Pageable pageable);
    boolean isExist(Contract contract);
}
