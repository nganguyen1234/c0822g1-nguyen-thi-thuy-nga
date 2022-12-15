package service;

import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;

import java.util.List;
import java.util.Map;

public interface IMatBangService {
    List<LoaiMatBang> layTatCaLoaiMatBang();
    List<TrangThai> layTatCaTrangThai();
    Map<String, String> themMoiMatBang(MatBang matBang);
    List<MatBang> layTatCaMatBang();
}
