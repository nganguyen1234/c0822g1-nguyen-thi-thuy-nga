package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.ICustomerTypeRepo;
import repository.Impl.customer.CustomerTypeRepo;
import service.ICustomerService;
import service.Impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    private ICustomerTypeRepo customerTypeRepo = new CustomerTypeRepo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
            case "search":
                searchCustomer(request, response);
            default:
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        String searchEmail = request.getParameter("searchEmail");
        String searchPhoneNumber = request.getParameter("searchPhoneNumber");
List<Customer> customerList = customerService.searchCustomer(searchName,searchPhoneNumber,searchEmail);
request.setAttribute("customerList",customerList);
        try {
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("newName");
        String birthday = request.getParameter("newBirthday");
        int gender = Integer.parseInt(request.getParameter("newGender"));
        String idCard = request.getParameter("newIdCard");
        String phoneNumber = request.getParameter("newPhoneNumber");
        String email = request.getParameter("newEmail");
        int customerTypeId = Integer.parseInt(request.getParameter("newCustomerType"));
        String address = request.getParameter("newAddress");
        CustomerType customerType = new CustomerType(customerTypeId);
        Customer customer = new Customer(id, customerType, name, birthday, gender, idCard, phoneNumber, email, address);
        boolean check = customerService.editCustomer(customer);
        String message = "successfully edited";
        if (!check) {
            message = "failed to edit";
        }
        try {
            response.sendRedirect("/customer?message=" + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = customerService.deleteCustomer(id);
        String message = "Successfully deleted";
        if (!check) {
            message = "Failed to delete";
        }
//        request.setAttribute("message", message);
        // showCustomerList(request, response);
        response.sendRedirect("/customer?message=" + message);
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        CustomerType customerType = new CustomerType(customerTypeId);
        Customer customer = new Customer(name, dateOfBirth, customerType, gender, idCard, phoneNumber, email, address);
        Map<String, String> errorMap = customerService.addCustomer(customer);
        String message = "Was successfully added ";
        if (!errorMap.isEmpty()) {
            message = "Failed to add";
            request.setAttribute("errorMap", errorMap);
            request.setAttribute("errorCustomer", customer);
//            request.setAttribute("name", errorMap.get("name"));
//            request.setAttribute("email", errorMap.get("email"));
//            request.setAttribute("phoneNumber", errorMap.get("phoneNumber"));
//            request.setAttribute("idCard", errorMap.get("idCard"));
            request.setAttribute("isModal", true);
            request.setAttribute("customerTypeList", customerTypeRepo.getAllCustomerType());
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("/customer?message=" + message);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddForm(request, response);
                break;
            default:
                showCustomerList(request, response);
        }
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Customer> customerList = customerService.getAllCustomer();
            List<CustomerType> customerTypeList = customerTypeRepo.getAllCustomerType();
            request.setAttribute("customerList", customerList);
            request.setAttribute("customerTypeList", customerTypeList);
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        List<String> typeList = customerService.getAllCustomerType();
        request.setAttribute("customerTypeList", typeList);
        try {
            request.getRequestDispatcher("/view/customer/add_modal.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
