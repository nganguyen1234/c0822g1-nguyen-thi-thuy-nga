package case_study.furama_resort.views;

import case_study.furama_resort.controllers.FuramaController;

import java.text.ParseException;

public class View {
    public static void main(String[] args) throws ParseException {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}
