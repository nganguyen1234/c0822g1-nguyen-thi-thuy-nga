package exercise3.service.impl;

import exercise3.model.Treatment;
import exercise3.service.ITreatmentService;
import exercise3.util.FileService;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreatmentServiceImpl implements ITreatmentService {
    private Set<Treatment> treatments = new TreeSet<>(new Comparator<Treatment>() {
        @Override
        public int compare(Treatment o1, Treatment o2) {
            return Integer.compare(o1.getOrder(), o2.getOrder());
        }
    });

    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }
    public void writeFile(){
        FileService fileService = new FileService();
        fileService.writeFile("src\\exercise3\\data\\lich_su_kham.csv",treatments);
    }
}
