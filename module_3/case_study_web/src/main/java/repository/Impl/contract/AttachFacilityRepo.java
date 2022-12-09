package repository.Impl.contract;

import model.contract.AttachFacility;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachFacilityRepo {
    private final String GET_ALL_ATTACH_FACILITY = "select *\n" +
            "from attach_facility\n" +
            "where is_deleted = 0;";

    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    public List<AttachFacility> getAllAttachFacility() {
        List<AttachFacility> attachFacilityList = new ArrayList<>();
        try {
            PreparedStatement ps = query(GET_ALL_ATTACH_FACILITY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double cost = rs.getDouble("cost");
                String unit = rs.getString("unit");
                String status = rs.getString("status");
                AttachFacility attachFacility = new AttachFacility(id, name, cost, unit, status);
                attachFacilityList.add(attachFacility);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attachFacilityList;
    }

    public AttachFacility getAttachFacility(int id) {
        List<AttachFacility> attachFacilityList = getAllAttachFacility();
        for (AttachFacility a : attachFacilityList) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
}
