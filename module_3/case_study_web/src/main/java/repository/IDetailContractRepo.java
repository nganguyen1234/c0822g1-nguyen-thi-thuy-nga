package repository;

import model.contract.AttachFacility;
import model.contract.DetailContract;

import java.util.List;

public interface IDetailContractRepo {
    List<DetailContract> getAllDetailContract();
    List<AttachFacility> getAllAttachFacility();
}
