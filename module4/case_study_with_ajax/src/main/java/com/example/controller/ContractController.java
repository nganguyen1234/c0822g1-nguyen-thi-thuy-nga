package com.example.controller;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(value = "/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping(value = "/show-list")
    public String displayContractList(Model model, Pageable pageable) {
        Page<Contract> contractPage = contractService.getAllContracts(pageable);
//        Map<AttachFacility,Integer> attachFacilityMap = contractDetailService.getAllAttachFacility();
        model.addAttribute("contractPage", contractPage);
        return "/contract/list";
    }
}
