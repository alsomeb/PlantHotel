package gui;

import plants.Cactus;
import plants.FlyTrap;
import plants.Palm;
import plants.Plant;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FoodHotelAppen {

    // Inkapslad Data, en lista med plantor som vi sedan jobbar med
    // Listan kan va final pga den KAN muteras men ej peka på en ny lista (objekt)
    private final List<Plant> plants; // Skapar pekare

    // Konstruktor
    public FoodHotelAppen() {
        plants = new ArrayList<>(); // pekar nu i minnet där data för ett arrayList objekt förvaras

        // Lägger in plantorna vi skall jobba med i arrayListan
        addPlants();

        // Välkomst ruta, Dynamisk återanvänds hela tiden
        message("Welcome to the Plant Hotel App");

        // Input Validerare, tar in listan för att söka mot den
        handleInput(plants);
    }

    // Skapar upp en lista med Plants som vi kan jobba med för sökningar av användaren.
    public void addPlants() {
        plants.add(new Cactus("Igge", 0.2));
        plants.add(new Palm("Laura", 5));
        plants.add(new FlyTrap("MeatLoaf", 0.7));
        plants.add(new Palm("Putte", 1.0));
    }


    private String userInputDialog() {
        while (true) {
            String input = JOptionPane.showInputDialog("What plant do you want to calculate food for?");

            if (input == null) {
                System.exit(0); // Klickar man cancel så blir de null och i DETTA fall avser vi att personen vill avsluta programmet
            } else if (input.isEmpty()) {
                message("Cant be empty, enter plant name!");
                continue;
            }
            return input;
        }
    }


    // Dynamisk message metod som återanvänds hela tiden för olika meddelanden i programmet
    private void message(String text) {
        JOptionPane.showMessageDialog(null, text);
    }


    // Hanterar input av användaren
    // Använder våran userInputDialog() där svaret läggs in i getPlantByNameElseThrow(), hittar den matchning --> Skriv ut svaret för användaren.
    // Lägger try Catch runt om då den returnerar ett NoSuchElementException som vi sedan hanterar med ett "felmeddelande" med våran message() om inte plantan fanns som vi sökte på.
    // Byggt Felhantering då OM man klickar cancel på Rutan så får man NullPointerException, så hanterar det felet med nestade Try catch --> DVS Cancel == Avsluta program
    private void handleInput(List<Plant> listOfPlants) {
        while(true) {
                String input = userInputDialog();
                try {
                    Plant currentPlant = getPlantByNameElseThrow(input, listOfPlants);
                    // Dynamiskt skriver ut mängd och mat typ, inte hårdkodat!
                    message("This plant needs " + currentPlant.calcNutrition() + " litres of " + currentPlant.getFoodTypen());
                    break;
                } catch (NoSuchElementException e) {
                    message("We dont have a plant named " + input);
                }
            }
    }

    // Öppnar upp en ström på plantListan
    // Använder den String som man skickade in som input och löper genom listan för att hitta match
    // Vid första match -> returnerar plantans objekt så vi kan jobba med objektet senare
    private static Plant getPlantByNameElseThrow(String searchQuery, List<Plant> listOfCurrentPlants) {
        return listOfCurrentPlants.stream()
                .filter(plant -> plant.getName().equalsIgnoreCase(searchQuery))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException());
    }

}
