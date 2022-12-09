package service.Impl;

import model.contract.AttachFacility;
import model.contract.DetailContract;
import repository.IDetailContractRepo;
import repository.Impl.contract.DetailContractRepo;
import service.IDetailContractService;

import java.util.List;

public class DetailContractService implements IDetailContractService {
    private IDetailContractRepo detailContractRepo = new DetailContractRepo();
    @Override
    public List<DetailContract> getAllDetailContract() {
        return detailContractRepo.getAllDetailContract();
    }

    @Override
    public List<AttachFacility> getAllAttachFacility() {
        return detailContractRepo.getAllAttachFacility();
    }
}
