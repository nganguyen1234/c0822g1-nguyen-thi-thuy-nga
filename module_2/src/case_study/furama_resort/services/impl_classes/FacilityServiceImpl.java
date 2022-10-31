package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Facility.Facility;
import case_study.furama_resort.models.Facility.Room;
import case_study.furama_resort.models.Facility.Villa;
import case_study.furama_resort.services.FacilityService;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class FacilityServiceImpl implements FacilityService {
//    private LinkedHashMap<Room, Integer> roomList = new LinkedHashMap<>();
//    private LinkedHashMap<Villa, Integer> villaList = new LinkedHashMap<>();
    private LinkedHashMap<Facility, Integer> facilityList = new LinkedHashMap<>();
    public int facilityListSize = facilityList.size();
//    @Override
//    public void addRoomInfo(Room room, int count) {
//        roomList.put(room, count);
//        facilityList.put(room, count);
//
//    }
////
////    @Override
//    public void addVillaInfo(Villa villa, int count) {
//        villaList.put(villa, count);
//        facilityList.put(villa, count);
//    }

//    public void displayAllFacilities() {
//
//        if (!villaList.isEmpty()) {
//            System.out.println("Villa list:");
//            Set<Villa> villaNameList = villaList.keySet();
//            villaNameList.forEach(villa -> System.out.println(villa.toString() + " has used:  " + villaList.get(villa)));
//        }
//        if (!roomList.isEmpty()) {
//            System.out.println("Room list:");
//            Set<Room> roomNameList = roomList.keySet();
//            roomNameList.forEach(room -> System.out.println(room.toString() + " has used:  " + roomList.get(room)));
//        }
//    }

//    public LinkedHashMap<Facility, Integer> checkMaintenance() {
//        LinkedHashMap<Facility, Integer> maintenanceList = new LinkedHashMap<>();
//        int key;
//        if (!villaList.isEmpty()) {
//            Set<Villa> villaNameList = villaList.keySet();
//            for (Villa villa : villaNameList) {
//                if ((key = villaList.get(villa)) > 5) {
//                    maintenanceList.put(villa, key);
//                }
//            }
//        }
//        if (!roomList.isEmpty()) {
//            Set<Room> roomNameList = roomList.keySet();
//            for (Room room : roomNameList) {
//                if ((key = roomList.get(room)) > 5) {
//                    maintenanceList.put(room, key);
//                }
//            }
//        }
//        return maintenanceList;
//    }
//
//    public void displayMaintenanceFacilities() {
//        LinkedHashMap<Facility, Integer> list = checkMaintenance();
//        if (!list.isEmpty()) {
//            System.out.println("Maintenance facility list:");
//            Set<Facility> facilities = list.keySet();
//            for (Facility facility : facilities) {
//                System.out.println(facility.toString() + " has used:  " + list.get(facility));
//            }
//        }
//    }

    //thử:
    public void displayAllFacilities() {

        if (!facilityList.isEmpty()) {
            System.out.println("facility list:");
            Set<Facility> facilities = facilityList.keySet();
            Iterator<Facility> facilities1 = facilities.iterator();
            AtomicInteger i = new AtomicInteger(1);       //**warning**
            facilities.forEach(facility -> System.out.println(i.getAndIncrement()+"\t" + facility.toString() + " has used:  " + facilityList.get(facility)));
    }
    }

    public void addFacility(Facility facility, int count) {
        facilityList.put(facility, count);
    }

    public LinkedHashMap<Facility, Integer> checkMaintenance() {
        LinkedHashMap<Facility, Integer> maintenanceList = new LinkedHashMap<>();
        int key;
        if (!facilityList.isEmpty()) {
            Set<Facility> facilities = facilityList.keySet();
            for (Facility facility : facilities) {
                if ((key = facilityList.get(facility)) > 5) {
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
            int i =1;
            for (Facility facility : facilities) {
                System.out.println(i++ + "\t"+ facility.toString() + " has used:  " + list.get(facility));
            }
        }
    }
//    public Facility getFacility(int index){
//        Map.Entry<Facility,Integer> entry =  facilityList.entrySet();
//        for (int i = 0; i < facilityList.size() ; i++) {
//            if (i == index){
//                return entry.getKey();
//            }
//        }
//    }
}
