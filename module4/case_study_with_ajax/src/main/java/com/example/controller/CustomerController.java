package com.example.controller;

import com.example.model.customer.Customer;
import com.example.dto.customer.CustomerDto;
import com.example.model.customer.CustomerType;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import com.example.util.exception.DataDuplicationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String showList(Model model, @RequestParam(value = "searchName", defaultValue = "") String name, @RequestParam(value = "searchEmail", defaultValue = "") String email, @RequestParam(value = "searchCustomerTypeId", defaultValue = "-1") int customerTypeId, @PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> customerList;
        if (customerTypeId == -1) {
            customerList = customerService.searchName(name, email, pageable);
        } else {
            customerList = customerService.searchName(name, email, customerTypeId, pageable);
        }
        CustomerDto customerDto = new CustomerDto();
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerList", customerList);
        model.addAttribute("size", customerList.getTotalPages());
        model.addAttribute("customerTypeList", customerTypeList);
        return "/customer/list";
    }

    @PostMapping(value = "/add")
    public String addNewCustomer(@Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        customerDto.validate(customerDto, bindingResult);
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        try {
            boolean check = customerService.addNewCustomer(customer);
            String mess;
            if (check) {
                mess = "Thêm mới thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
            return "redirect:/customer/show-list";
        } catch (DataDuplicationException dataDuplicationException) {
            if (dataDuplicationException.getErrorMap().get("email") != null) {
                bindingResult.rejectValue("email", "email", "Email bạn vừa nhập đã tồn tại");
            }
            if (dataDuplicationException.getErrorMap().get("idCard") != null) {
                bindingResult.rejectValue("idCard", "idCard", "số CMND bạn vừa nhập đã tồn tại");
            }
            if (dataDuplicationException.getErrorMap().get("phoneNumber") != null) {
                bindingResult.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại bạn vừa nhập đã tồn tại");
            }
        }
        Pageable pageable = null;
        Page<Customer> customerList = customerService.searchName("", "", pageable);
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        boolean isModal = true;
        model.addAttribute("isModal", isModal);
        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", customerTypeList);
        return "/customer/list";
    }

    @PostMapping(value = "/edit")
    public String editCustomer(@Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        customerDto.validate(customerDto, bindingResult);
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        try {
            boolean check = customerService.editCustomer(customer);
            String mess;
            if (check) {
                mess = "Chỉnh sửa thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
            return "redirect:/customer/show-list";
        } catch (DataDuplicationException dataDuplicationException) {
            if (dataDuplicationException.getErrorMap().get("email") != null) {
                bindingResult.rejectValue("email", "email", "Email bạn vừa nhập đã tồn tại");
            }
            if (dataDuplicationException.getErrorMap().get("idCard") != null) {
                bindingResult.rejectValue("idCard", "idCard", "số CMND bạn vừa nhập đã tồn tại");
            }
            if (dataDuplicationException.getErrorMap().get("phoneNumber") != null) {
                bindingResult.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại bạn vừa nhập đã tồn tại");
            }
        }
        Pageable pageable = null;
        Page<Customer> customerList = customerService.searchName("", "", pageable);
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        boolean isModal = true;
        model.addAttribute("isEditModal", isModal);
        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", customerTypeList);
        return "/customer/list";
    }

    @PostMapping(value = "/delete")
    public String deleteCustomer(CustomerDto customerDto, Model model, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(customerDto.getId());
        customer.setDeleted(true);
        boolean check = customerService.deleteCustomer(customer);
        String mess;
        if (check) {
            mess = "Xóa thành công";
        } else {
            mess = "Đã xảy ra lỗi";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/customer/show-list";
    }
}
