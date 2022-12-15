package repository.impl;

import model.LoaiMatBang;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiMatBangRepository {
    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    public List<LoaiMatBang> layTatCaLoaiMatBang() {
        List<LoaiMatBang> loaiMatBangList = new ArrayList<>();
        try {
            PreparedStatement ps = query("select * from loai_mat_bang ;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maLoai = rs.getInt("ma_loai_mat_bang");
                String tenLoai = rs.getString("loai_mat_bang");
                LoaiMatBang loaiMatBang = new LoaiMatBang(maLoai, tenLoai);
                loaiMatBangList.add(loaiMatBang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return loaiMatBangList;
    }
}
