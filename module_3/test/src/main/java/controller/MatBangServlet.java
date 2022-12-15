package controller;

import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;
import service.IMatBangService;
import service.impl.MatBangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MatBangServlet", value = "/mat-bang")
public class MatBangServlet extends HttpServlet {
    private IMatBangService matBangService = new MatBangService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "themMoi":
                themMoiMatBang(request, response);
                break;
        }
    }

    private void themMoiMatBang(HttpServletRequest request, HttpServletResponse response) {
        String maMatBang = request.getParameter("maMatBang");
        double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        int maTrangThai = Integer.parseInt(request.getParameter("trangThai"));
        TrangThai trangThai = new TrangThai(maTrangThai);
        int tang = Integer.parseInt(request.getParameter("tang"));
        int maLoai = Integer.parseInt(request.getParameter("loaiVanPhong"));
        LoaiMatBang loaiMatBang = new LoaiMatBang(maLoai);
        String moTa = request.getParameter("moTa");
        double gia = Double.parseDouble(request.getParameter("gia"));
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");
        MatBang matBang = new MatBang(maMatBang, dienTich, trangThai, tang, loaiMatBang, moTa, gia, ngayBatDau, ngayKetThuc);
        Map<String, String> danhSachLoi = matBangService.themMoiMatBang(matBang);
        if (danhSachLoi.isEmpty()) {
            request.setAttribute("mess", "thêm mới thành công");
        }
        try {
            request.getRequestDispatcher("/view/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "themMoi":
                hienThiThemMoi(request, response);
                break;

            default:
        hienThi(request,response);}
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) {
        List<MatBang> matBangs = matBangService.layTatCaMatBang();
        request.setAttribute("matBangList",matBangs);
        try {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void hienThiThemMoi(HttpServletRequest request, HttpServletResponse response) {
        List<TrangThai> trangThaiList = matBangService.layTatCaTrangThai();
        List<LoaiMatBang> loaiMatBangList = matBangService.layTatCaLoaiMatBang();
        request.setAttribute("trangThaiList", trangThaiList);
        request.setAttribute("loaiMatBangList", loaiMatBangList);
        try {
            request.getRequestDispatcher("/view/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
