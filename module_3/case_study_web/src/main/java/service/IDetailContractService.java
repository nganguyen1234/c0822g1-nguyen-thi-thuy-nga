package service;

import model.contract.AttachFacility;
import model.contract.DetailContract;

import java.util.List;

public interface IDetailContractService {
    List<DetailContract> getAllDetailContract();
    List<AttachFacility> getAllAttachFacility();
}
