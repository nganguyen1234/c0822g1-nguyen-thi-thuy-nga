package repository.Impl.facility;

import model.service.Facility;
import model.service.FacilityType;
import model.service.RentType;
import repository.BaseRepository;
import repository.IFacilityRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepo implements IFacilityRepo {
    private final String SELECT_ALL_FACILITY = "select f.*,ft.name as facility_type_name,rt.name as rent_type_name from facility as f left join facility_type ft on f.facility_type_id = ft.id left join rent_type rt on f.rent_type_id = rt.id;";
    private final String INSERT_INTO_FACILITY = "insert into facility( name, area, cost, max_people, rent_type_id, facility_type_id, standard_room, description_other_convenience, pool_area, number_of_floors, facility_free)\n" +
            " values (?,?,?,?,?,?,?,?,?,?,?);";

    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }
    public boolean addFacility(Facility facility){
        try {
            PreparedStatement ps = query(INSERT_INTO_FACILITY);
            ps.setString(1,facility.getName());
            ps.setInt(2,facility.getArea());
            ps.setDouble(3,facility.getCost());
            ps.setInt(4,facility.getMaxPeople());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<RentType> getAllRentType() {
        RentTypeRepo rentTypeRepo = new RentTypeRepo();
        return rentTypeRepo.getAllRentType();
    }

    public List<FacilityType> getAllFacilityType() {
        FacilityTypeRepo facilityTypeRepo = new FacilityTypeRepo();
        return facilityTypeRepo.getAllFacilityType();
    }

    public List<Facility> getAllFacility() {
        List<Facility> facilityList = new ArrayList<>();
        try {
            PreparedStatement ps = query(SELECT_ALL_FACILITY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int area = rs.getInt("area");
                double cost = rs.getDouble("cost");
                int maxPeople = rs.getInt("max_people");
                int rentTypeId = rs.getInt("rent_type_id");
                String rentTypeName = rs.getString("rent_type_name");
                RentType rentType = new RentType(rentTypeId, rentTypeName);
                int facilityTypeId = rs.getInt("facility_type_id");
                String facilityTypeName = rs.getString("facility_type_name");
                FacilityType facilityType = new FacilityType(facilityTypeId, facilityTypeName);
                String standardRoom = rs.getString("standard_room");
                String descriptionOtherConvenience = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberOfFloors = rs.getInt("number_of_floors");
                String facilityFree = rs.getString("facility_free");
                Facility facility = new Facility(id, name, area, cost, maxPeople, rentType, facilityType, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree);
                facilityList.add(facility);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityList;
    }
}
