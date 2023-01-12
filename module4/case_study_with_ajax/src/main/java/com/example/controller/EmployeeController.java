package com.example.controller;

import com.example.dto.customer.CustomerDto;
import com.example.model.employee.*;
import com.example.service.employee.IEmployeeService;
import com.example.util.exception.DataDuplicationException;
import com.sun.org.apache.xpath.internal.operations.Mod;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.Size;
import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(value = "/show-list")
    public String showList(@RequestParam(value = "searchName", defaultValue = "") String name, @RequestParam(value = "searchEmail", defaultValue = "") String email, Model model, @PageableDefault(size = 3) Pageable pageable) {
        Page<Employee> employeePage = employeeService.getEmployeePage(name, email, pageable);
        model.addAttribute("employeePage", employeePage);
        List<Position> positionList = employeeService.getPositionList();
        List<Division> divisionList = employeeService.getDivisionList();
        List<EducationDegree> educationDegreeList = employeeService.getEducationDegreeList();
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("positionList", positionList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("employeeDto", employeeDto);
        return "/employee/list";
    }


    @GetMapping(value = "/show-add-form")
    public String showAddForm(Model model) {
        List<Position> positionList = employeeService.getPositionList();
        List<Division> divisionList = employeeService.getDivisionList();
        List<EducationDegree> educationDegreeList = employeeService.getEducationDegreeList();
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("positionList", positionList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("employeeDto", employeeDto);
        return "/employee/add";
    }

    @PostMapping(value = "/add")
    public String addEmployee(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        String mess;
        Employee check = null;
        try {
            check = employeeService.addEmployee(employee);
        } catch (DataDuplicationException e) {
            if (e.getErrorMap().containsKey("idCard")) {
                bindingResult.rejectValue("idCard", "idCard", e.getErrorMap().get("idCard"));
            }
        }
        if (bindingResult.hasErrors()) {
            List<Position> positionList = employeeService.getPositionList();
            List<Division> divisionList = employeeService.getDivisionList();
            List<EducationDegree> educationDegreeList = employeeService.getEducationDegreeList();
            model.addAttribute("positionList", positionList);
            model.addAttribute("divisionList", divisionList);
            model.addAttribute("educationDegreeList", educationDegreeList);
            return "/employee/add";
        }
        if (check != null) {
            mess = "Đã thêm mới thành công";
        } else {
            mess = "Đã xảy ra lỗi";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/employee/show-list";
    }

    @PostMapping(value = "/edit")
    public String editEmployee(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            return "employee/list";
        }
        return "redirect:/employee/show-list";
    }
}
