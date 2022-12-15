package repository;

import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;

import java.sql.SQLException;
import java.util.List;

public interface IMatBangRepository {
    boolean themMatBang(MatBang matBang) throws SQLException;
    List<LoaiMatBang> layTatCaLoaiMatBang();
    List<TrangThai> layTatCaTrangThai();
    List<MatBang> layTatCaMatBang();


}
