package com.example.controller;

import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.service.IFacilityService;
import com.example.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;
    @GetMapping(value = "/show-list")
    public String showList(Model model, @RequestParam(value = "searchName", defaultValue = "") String name, @RequestParam(value = "searchTypeId", defaultValue = "") String typeId, Pageable pageable) {
        Page<Facility> facilityPage;
        if (typeId.equals("")) {
            facilityPage = facilityService.searchName(name,pageable);
        } else {
            facilityPage = facilityService.searchNameAndFacilityType(name, Integer.parseInt(typeId),pageable);
        }
        List<FacilityType> facilityTypeList = facilityTypeService.getAllType();
        model.addAttribute("facility",new Facility());
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("facilityTypeList",facilityTypeList);
        return "facility/list";
    }
}
