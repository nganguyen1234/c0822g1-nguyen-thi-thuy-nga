package com.example.controller;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerDto;
import com.example.model.customer.CustomerType;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping(value = "/show-list")
    public String showList(Model model, @RequestParam(value = "searchName", defaultValue = "") String name, @RequestParam(value = "searchEmail", defaultValue = "") String email, @RequestParam(value = "searchPhoneNumber", defaultValue = "") String phoneNumber, @PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> customerList = customerService.searchName(name, email, phoneNumber, pageable);
        CustomerDto customerDto = new CustomerDto();
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", customerTypeList);
        return "/customer/list";
    }
@PostMapping(value = "/add")
    public String addNewCustomer(@Validated CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/customer/list";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            boolean check = customerService.addNewCustomer(customer);
            String mess;
            if (check) {
                mess = "Thêm mới thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
            return "redirect:/customer/show-list";
        }
    }
}
