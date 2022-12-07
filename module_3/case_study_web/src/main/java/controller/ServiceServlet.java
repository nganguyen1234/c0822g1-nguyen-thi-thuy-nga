package controller;

import model.service.Facility;
import model.service.FacilityType;
import model.service.RentType;
import service.IFacilityService;
import service.Impl.FacilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/service")
public class ServiceServlet extends HttpServlet {
    private IFacilityService facilityService = new FacilityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                addFacility(request, response);
                break;
            default:
                showFacilityList(request, response);
        }
    }

    private void showFacilityList(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = facilityService.getAllFacility();
        request.setAttribute("facilityList", facilityList);
        List<RentType> rentTypeList = facilityService.getAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);
        List<FacilityType> facilityTypeList = facilityService.getAllFacilityType();
        request.setAttribute("facilityTypeList", facilityTypeList);
        try {
            request.getRequestDispatcher("/view/service/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addFacility(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        RentType rentType = new RentType(rentTypeId);
        String standardRoom = request.getParameter("standardRoom");
        FacilityType facilityType = new FacilityType(Integer.parseInt(request.getParameter("facilityTypeId")));
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        String facilityFree = request.getParameter("facilityFree");
        Facility facility = new Facility(name, area, cost, maxPeople, rentType, facilityType, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree);
        facilityService.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showFacilityList(request, response);
        }
    }
}
