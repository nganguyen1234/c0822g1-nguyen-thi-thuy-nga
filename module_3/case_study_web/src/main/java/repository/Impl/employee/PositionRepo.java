package repository.Impl.employee;

import model.employee.Position;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepo {
    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    public List<Position> getAllPosition() {
        List<Position> positionList = new ArrayList<>();
        try {
            PreparedStatement ps = query("select * from position where is_deleted =0");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                positionList.add(new Position(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return positionList;
    }
}
