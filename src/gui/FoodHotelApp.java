package gui;

import plants.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FoodHotelApp {


    public static void runHotelApp() {
        // Ge tbx en lista med Plants, som sedan används för när man söker efter plantor
        List<Plant> plantor = plantMaker();

        // Välkomst ruta, Dynamisk återanvänds hela tiden
        message("Welcome to the Plant Hotel App");

        // Fråga om planta
        String plantVal = userInputDialog();

        // Ge svar
        answer(plantVal, plantor);


    }

    // Metoder som använts i själva runHotelApp(), PRIVATA Eftersom vi bara visar runHotelApp() (publik) för våran main metod utanför detta paket.
    private static List<Plant> plantMaker() {
        Plant igge = new Cactus("Igge", 0.2);
        Plant laura = new Palm("Laura", 5);
        Plant meatLoaf = new FlyTrap("MeatLoaf", 0.7);
        Plant putte = new Palm("Putte", 1.0);

        return new ArrayList<>(
                List.of(igge, laura, meatLoaf, putte)
        );
    }


    private static String userInputDialog() {
        return JOptionPane.showInputDialog("What plant do you want to calculate food for?");
    }

    private static void message(String text) {
        JOptionPane.showMessageDialog(null, text);
    }


    private static void answer(String input, List<Plant> listOfPlants) {
        try {
            Plant currentPlant = getPlantByName(input, listOfPlants);
            message("This plant needs " + currentPlant.calcNutrition() + " litres of " + currentPlant.getFoodType());
        }catch (NoSuchElementException e) {
            message("We dont have a plant named " + input);
        }

    }

    private static Plant getPlantByName(String searchQuery, List<Plant> listOfCurrentPlants) {
        return listOfCurrentPlants.stream()
                .filter(plant -> plant.getName().equalsIgnoreCase(searchQuery))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException());
    }
}
