package repository.Impl.contract;

import model.contract.AttachFacility;
import model.contract.Contract;
import model.contract.DetailContract;
import repository.BaseRepository;
import repository.IDetailContractRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DetailContractRepo implements IDetailContractRepo {
    private final String GET_ALL_DETAIL_CONTRACT = "select *\n" +
            "from contract_detail\n" +
            "where is_deleted = 0;";
    private ContractRepo contractRepo = new ContractRepo();
    private AttachFacilityRepo attachFacilityRepo = new AttachFacilityRepo();

    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    public List<DetailContract> getAllDetailContract() {
        List<DetailContract> detailContractList = new ArrayList<>();
        try {
            PreparedStatement ps = query(GET_ALL_DETAIL_CONTRACT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int contractId = rs.getInt("contract_id");
                Contract contract = contractRepo.getContract(contractId);
                int attachFacilityId = rs.getInt("attach_facility_id");
                AttachFacility attachFacility = attachFacilityRepo.getAttachFacility(attachFacilityId);
                int quantity = rs.getInt("quantity");
                DetailContract detailContract = new DetailContract(id, contract, attachFacility, quantity);
                detailContractList.add(detailContract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return detailContractList;
    }
    public List<AttachFacility> getAllAttachFacility(){
        return attachFacilityRepo.getAllAttachFacility();
    }
}
