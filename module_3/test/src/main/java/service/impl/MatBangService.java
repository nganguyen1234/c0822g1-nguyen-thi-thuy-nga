package service.impl;

import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;
import repository.IMatBangRepository;
import repository.impl.MatBangRepository;
import service.IMatBangService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatBangService implements IMatBangService {

    IMatBangRepository matBangRepository = new MatBangRepository();

    public Map<String, String> themMoiMatBang(MatBang matBang) {
        Map<String, String> danhSachLoi = new HashMap<>();
        try {
            matBangRepository.themMatBang(matBang);
        } catch (SQLException throwables) {
            if (throwables.getMessage().contains("ma_mat_bang")) {
                danhSachLoi.put("maMatBang", "Mã mặt bằng vừa thêm đã tồn tại");
            }
        }
        return danhSachLoi;
    }

    @Override
    public List<MatBang> layTatCaMatBang() {
        return matBangRepository.layTatCaMatBang();
    }

    @Override
    public List<LoaiMatBang> layTatCaLoaiMatBang() {
        return matBangRepository.layTatCaLoaiMatBang();
    }

    @Override
    public List<TrangThai> layTatCaTrangThai() {
        return matBangRepository.layTatCaTrangThai();
    }
}
