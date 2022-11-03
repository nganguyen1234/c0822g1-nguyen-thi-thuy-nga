package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Facility.Facility;
import case_study.furama_resort.models.Facility.Room;
import case_study.furama_resort.models.Facility.Villa;
import case_study.furama_resort.services.FacilityService;
import case_study.furama_resort.common.FileService;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    FileService fileService = new FileService();
    private final String roomFilePath = "src\\case_study\\furama_resort\\data\\room.csv";
    private final String villaFilePath = "src\\case_study\\furama_resort\\data\\villa.csv";
    private LinkedHashMap<Room, Integer> roomMap;
    private LinkedHashMap<Villa, Integer> villaMap;
    private LinkedHashMap<Facility, Integer> facilityMap;

    public void readVillaFile() {
        villaMap = fileService.readVillaMap(villaFilePath);
    }

    public void readRoomFile() {
        roomMap = fileService.readRoomMap(roomFilePath);
    }

    public void readFacilityFile() {
        facilityMap = fileService.readFacility(villaFilePath, roomFilePath);
    }

    public void writeVillaFile() {
        fileService.writeVilla(villaFilePath, villaMap);
    }

    public void writeRoomFile() {
        fileService.writeRoom(roomFilePath, roomMap);
    }

    public void addRoomInfo(Room room) {
        readRoomFile();
        roomMap.put(room, 0);
        writeRoomFile();
    }

    public void addVillaInfo(Villa villa) {
        readVillaFile();
        villaMap.put(villa, 0);
        writeVillaFile();
    }

    public void displayAllFacilities() {
        readFacilityFile();
        if (!facilityMap.isEmpty()) {
            System.out.println("facility list:");
            Set<Facility> facilities = facilityMap.keySet();
            facilities.forEach(facility -> {
                System.out.println(facility + "\thas used:" + facilityMap.get(facility));
            });
        }
    }

    public LinkedHashMap<Facility, Integer> checkMaintenance() {
        readFacilityFile();
        LinkedHashMap<Facility, Integer> maintenanceList = new LinkedHashMap<>();
        int key;
        if (!facilityMap.isEmpty()) {
            Set<Facility> facilities = facilityMap.keySet();
            for (Facility facility : facilities) {
                if ((key = facilityMap.get(facility)) > 5) {
                    maintenanceList.put(facility, key);
                }
            }
        }
        return maintenanceList;
    }

    public void displayMaintenanceFacilities() {
        LinkedHashMap<Facility, Integer> list = checkMaintenance();
        if (!list.isEmpty()) {
            System.out.println("Maintenance facility list:");
            Set<Facility> facilities = list.keySet();
            int i = 1;
            for (Facility facility : facilities) {
                System.out.println(i++ + "\t" + facility.toString() + " has used:  " + list.get(facility));
            }
        }
    }

    public boolean containsServiceId(String id) {
        readFacilityFile();
        Set<Facility> facilities = facilityMap.keySet();
        List<Facility> facilityArrayList = new ArrayList<>();
        facilityArrayList.addAll(facilities);
        for (int i = 0; i < facilityArrayList.size(); i++) {
            if (facilityArrayList.get(i).getServiceId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsServiceName(String name) {
        readFacilityFile();
        Set<Facility> facilities = facilityMap.keySet();
        List<Facility> facilityArrayList = new ArrayList<>();
        facilityArrayList.addAll(facilities);
        for (int i = 0; i < facilityArrayList.size(); i++) {
            if (facilityArrayList.get(i).getServiceName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
