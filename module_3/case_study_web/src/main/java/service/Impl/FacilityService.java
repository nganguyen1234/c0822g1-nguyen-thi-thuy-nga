package service.Impl;

import model.service.Facility;
import model.service.FacilityType;
import model.service.RentType;
import repository.IFacilityRepo;
import repository.Impl.facility.FacilityRepo;
import service.IFacilityService;

import java.util.List;

public class FacilityService implements IFacilityService {
    private IFacilityRepo facilityRepo = new FacilityRepo();

    @Override
    public List<RentType> getAllRentType() {
        return facilityRepo.getAllRentType();
    }

    @Override
    public List<FacilityType> getAllFacilityType() {
        return facilityRepo.getAllFacilityType();
    }

    @Override
    public List<Facility> getAllFacility() {
        return facilityRepo.getAllFacility();
    }
}
