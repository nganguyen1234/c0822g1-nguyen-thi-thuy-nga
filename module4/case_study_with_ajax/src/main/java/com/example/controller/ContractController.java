package com.example.controller;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;


    @GetMapping(value = "/show-list")
    public String displayContractList(Model model, Pageable pageable) {
        Page<Contract> contractPage = contractService.getAllContracts(pageable);
        List<AttachFacility> attachFacilityList = attachFacilityService.getAllAttachFacility();
        model.addAttribute("attachFacilityList", attachFacilityList);
        ContractDetail contractDetail = new ContractDetail();
        model.addAttribute("contractDetail", contractDetail);
//        Map<AttachFacility,Integer> attachFacilityMap = contractDetailService.getAllAttachFacility();
        model.addAttribute("contractPage", contractPage);
        return "/contract/list";
    }

    @PostMapping("/add-attach-facility")
    public String addDetailContract(@ModelAttribute("contractDetail") ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        boolean check = contractDetailService.addContractDetail(contractDetail);
        String mess;
        if (check) {
            mess = "Đã thêm mới dịch vụ đi kèm thành công";
        } else {
            mess = "Đã xảy ra lỗi";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/contract/show-list";
    }
}
