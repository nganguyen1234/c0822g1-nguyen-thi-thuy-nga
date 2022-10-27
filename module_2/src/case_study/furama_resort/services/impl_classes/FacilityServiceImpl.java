package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Facility.Facility;
import case_study.furama_resort.models.Facility.Room;
import case_study.furama_resort.models.Facility.Villa;
import case_study.furama_resort.services.FacilityService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {
    private LinkedHashMap<Room, Integer> roomList = new LinkedHashMap<>();
    private LinkedHashMap<Villa, Integer> villaList = new LinkedHashMap<>();


    @Override
    public void addRoomInfo(Room room, int count) {
        roomList.put(room, count);
    }

    @Override
    public void addVillaInfo(Villa villa, int count) {
        villaList.put(villa, count);
    }

    @Override
    public void display() {
        if (!roomList.isEmpty()) {
            System.out.println("Room list:");
            Set<Room> roomNameList = roomList.keySet();
            for (Room room : roomNameList) {
                System.out.println(room.toString() + " has used:  " + roomList.get(room));
            }
        }
        if (!villaList.isEmpty()) {
            System.out.println("Villa list:");
            Set<Villa> villaNameList = villaList.keySet();
            for (Villa villa : villaNameList) {
                System.out.println(villa.toString() + " has used:  " + villaList.get(villa));
            }
        }
    }

    public LinkedHashMap<Facility,Integer> checkMaintenance() {
        LinkedHashMap<Facility, Integer> maintenanceList = new LinkedHashMap<>();
        int key;
        if (!roomList.isEmpty()) {
            System.out.println("Room list:");
            Set<Room> roomNameList = roomList.keySet();

            for (Room room : roomNameList) {
                if ((key = roomList.get(room)) > 5) {
                    maintenanceList.put(room, key);
                }
            }
        }
        if (!villaList.isEmpty()) {
            System.out.println("Villa list:");
            Set<Villa> villaNameList = villaList.keySet();
            for (Villa villa : villaNameList) {
                if ((key = roomList.get(villa)) > 5) {
                    maintenanceList.put(villa, key);
                }
            }
        }
        return maintenanceList;
    }

    public void displayMaintenanceFacilities() {
        LinkedHashMap<Facility, Integer> list = checkMaintenance();
        if (!list.isEmpty()){
            System.out.println("Maintenance facility list:");
            Set<Facility> facilities = list.keySet();
            for (Facility facility : facilities) {
                System.out.println(facility.toString() + " has used:  " + list.get(facility));
            }
        }
    }
}
