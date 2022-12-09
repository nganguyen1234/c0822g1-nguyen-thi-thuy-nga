package controller;

import model.contract.AttachFacility;
import model.contract.DetailContract;
import service.IDetailContractService;
import service.Impl.DetailContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", value = "/contract")
public class ContractServlet extends HttpServlet {
    private IDetailContractService detailContractService = new DetailContractService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showContractList(request, response);
        }
    }

    private void showContractList(HttpServletRequest request, HttpServletResponse response) {
        List<DetailContract> detailContractList = detailContractService.getAllDetailContract();
        request.setAttribute("detailContractList", detailContractList);
        List<AttachFacility> attachFacilityList = detailContractService.getAllAttachFacility();
        request.setAttribute("attachFacilityList",attachFacilityList);
        try {
            request.getRequestDispatcher("/view/contract/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
