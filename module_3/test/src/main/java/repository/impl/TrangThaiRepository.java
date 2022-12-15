package repository.impl;

import model.TrangThai;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrangThaiRepository {
    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    public List<TrangThai> layTatCaTrangThai() {
        List<TrangThai> trangThaiList = new ArrayList<>();
        try {
            PreparedStatement ps = query("select * from trang_thai;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maTrangThai = rs.getInt("ma_trang_thai");
                String tenTrangThai = rs.getString("trang_thai");
                TrangThai trangThai = new TrangThai(maTrangThai, tenTrangThai);
                trangThaiList.add(trangThai);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return trangThaiList;
    }
}
