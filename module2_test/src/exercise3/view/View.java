package exercise3.view;

import exercise3.controller.TreatmentController;
import exercise3.model.Treatment;

public class View {
    public static void main(String[] args) {
        TreatmentController treatmentController = new TreatmentController();
        treatmentController.displayMenu();
    }


}
