package oop_exercise.view;

import oop_exercise.controller.TransportController;

public class View {
    public static void main(String[] args) {
        TransportController transportController = new TransportController();
        transportController.displayMenu();
    }
}
