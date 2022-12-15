package repository.impl;

import com.sun.org.apache.regexp.internal.RE;
import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;
import repository.BaseRepository;
import repository.IMatBangRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatBangRepository implements IMatBangRepository {
    private final String THEM_MOI = "insert into mat_bang(ma_mat_bang, ma_trang_thai, dien_tich, tang, ma_loai_mat_bang, mo_ta_chi_tiet, gia_cho_thue, ngay_bat_dau, ngay_ket_thuc) values \n" +
            "(?,?,?,?,?,?,?,?,?);";
    private final String HIEN_THI = "select mb.*, lmb.loai_mat_bang, tt.trang_thai\n" +
            "from mat_bang as mb\n" +
            "         left join loai_mat_bang lmb on mb.ma_loai_mat_bang = lmb.ma_loai_mat_bang\n" +
            "         left join trang_thai tt on mb.ma_trang_thai = tt.ma_trang_thai\n" +
            "order by mb.dien_tich;";

    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    //    public List<MatBang> hienThiDSMatBang(){
//        PreparedStatement ps = query("")
//    }
    public List<LoaiMatBang> layTatCaLoaiMatBang() {
        LoaiMatBangRepository loaiMatBangRepository = new LoaiMatBangRepository();
        return loaiMatBangRepository.layTatCaLoaiMatBang();
    }

    public boolean themMatBang(MatBang matBang) throws SQLException {
        PreparedStatement ps = query(THEM_MOI);
        ps.setString(1, matBang.getMaMatBang());
        ps.setInt(2, matBang.getTrangThai().getMaTrangThai());
        ps.setDouble(3, matBang.getDienTich());
        ps.setInt(4, matBang.getTang());
        ps.setInt(5, matBang.getLoaiMatBang().getMaLoai());
        ps.setString(6, matBang.getMoTa());
        ps.setDouble(7, matBang.getGiaChoThue());
        ps.setString(8, matBang.getNgayBatDau());
        ps.setString(9, matBang.getNgayKetThuc());
        return ps.executeUpdate() > 0;
    }

    public List<MatBang> layTatCaMatBang() {
        List<MatBang> matBangs = new ArrayList<>();
        try {
            PreparedStatement ps = query(HIEN_THI);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maMatBang = rs.getString("ma_mat_bang");
                int maTrangThai = rs.getInt("ma_trang_thai");
                String tenTrangThai = rs.getString("trang_thai");
                TrangThai trangThai = new TrangThai(maTrangThai, tenTrangThai);
                double dienTich = rs.getDouble("dien_tich");
                int tang = rs.getInt("tang");
                int maLoai = rs.getInt("ma_loai_mat_bang");
                String loaiMatBang = rs.getString("loai_mat_bang");
                LoaiMatBang loaiMatBang1 = new LoaiMatBang(maLoai, loaiMatBang);
                String moTa = rs.getString("mo_ta_chi_tiet");
                double gia = rs.getDouble("gia_cho_thue");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngay_ket_thuc = rs.getString("ngay_ket_thuc");
                MatBang matBang = new MatBang(maMatBang, dienTich, trangThai, tang, loaiMatBang1, moTa, gia, ngayBatDau, ngay_ket_thuc);
                matBangs.add(matBang);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBangs;
    }

    public List<TrangThai> layTatCaTrangThai() {
        TrangThaiRepository trangThaiRepository = new TrangThaiRepository();
        return trangThaiRepository.layTatCaTrangThai();
    }
}
