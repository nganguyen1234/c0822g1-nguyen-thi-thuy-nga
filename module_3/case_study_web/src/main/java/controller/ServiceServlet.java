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
            case "delete":
                deleteFacility(request, response);
                break;
            case "edit":
                editFacility(request,response);
            default:
                showFacilityList(request, response);
        }
    }

    private void editFacility(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("editId"));
        String name = request.getParameter("newName");
        int area = Integer.parseInt(request.getParameter("newArea"));
        double cost = Double.parseDouble(request.getParameter("newCost"));
        int maxPeople = Integer.parseInt(request.getParameter("newMaxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("newRentTypeId"));
        RentType rentType = new RentType(rentTypeId);
        String standardRoom = request.getParameter("newStandardRoom");
        FacilityType facilityType = new FacilityType(Integer.parseInt(request.getParameter("editFacilityType")));
        String descriptionOtherConvenience = request.getParameter("newDescriptionOtherConvenience");
        String poolAreaStr = request.getParameter("newPoolArea");
        double poolArea = 0;
        if (poolAreaStr != "") {
            poolArea = Double.parseDouble(poolAreaStr);
        }
        String numberOfFloorsStr = request.getParameter("newNumberOfFloors");
        int numberOfFloors = 0;
        if (numberOfFloorsStr != "") {
            numberOfFloors = Integer.parseInt(numberOfFloorsStr);
        }
        String facilityFree = request.getParameter("newFacilityFree");
        Facility facility = new Facility(id,name, area, cost, maxPeople, rentType, facilityType, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree);
        boolean check = facilityService.editFacility(facility);
        String message = "successfully edited";
        if (!check) {
            message = "failed to edit";
        }
        request.setAttribute("message", message);
        showFacilityList(request, response);
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = facilityService.deleteFacility(id);
        String message = "Successfully deleted";
        if (!check) {
            message = "Failed to delete";
        }
        request.setAttribute("message", message);
        showFacilityList(request, response);
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
        String poolAreaStr = request.getParameter("poolArea");
        double poolArea = 0;
        if (poolAreaStr != "") {
            poolArea = Double.parseDouble(poolAreaStr);
        }
        String numberOfFloorsStr = request.getParameter("numberOfFloors");
        int numberOfFloors = 0;
        if (numberOfFloorsStr != "") {
            numberOfFloors = Integer.parseInt(numberOfFloorsStr);
        }
        String facilityFree = request.getParameter("facilityFree");
        Facility facility = new Facility(name, area, cost, maxPeople, rentType, facilityType, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree);
        boolean check = facilityService.addFacility(facility);
        String message = "Was successfully added";
        if (!check) {
            message = "Failed to add";
        }
        request.setAttribute("message", message);
        showFacilityList(request, response);
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
