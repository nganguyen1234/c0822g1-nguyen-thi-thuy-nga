package repository;

import model.service.Facility;
import model.service.FacilityType;
import model.service.RentType;
import java.util.List;

public interface IFacilityRepo {
    List<RentType> getAllRentType();
    List<FacilityType> getAllFacilityType();
    List<Facility> getAllFacility();
}
