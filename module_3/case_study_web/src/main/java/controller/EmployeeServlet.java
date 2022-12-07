package controller;

import model.employee.*;
import service.IEmployeeService;
import service.Impl.EmployeeService;

import javax.print.Doc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addEmployee(request, response);
                break;
        }
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        Position position = new Position(positionId);
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        EducationDegree educationDegree = new EducationDegree(educationDegreeId);
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Division division = new Division(divisionId);
        User user = new User(request.getParameter("username"));
        Employee employee = new Employee(name, birthday, idCard, salary, phoneNumber, email, address, position, educationDegree, division, user);
        boolean check = employeeService.addEmployee(employee);
        String message = "Was successfully added ";
        if (!check) {
            message = "Failed to add";
        }
        request.setAttribute("message", message);
        showEmployeeList(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showEmployeeList(request, response);
        }
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        request.setAttribute("employeeList", employeeList);
        List<Division> divisionList = employeeService.getAllDivision();
        request.setAttribute("divisionList", divisionList);
        List<Position> positionList = employeeService.getAllPosition();
        request.setAttribute("positionList", positionList);
        List<EducationDegree> educationDegreeList = employeeService.getAllEducationDegree();
        request.setAttribute("educationDegreeList", educationDegreeList);
        try {
            request.getRequestDispatcher("/view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
