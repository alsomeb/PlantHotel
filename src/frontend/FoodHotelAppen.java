package frontend;

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
    // Listan kan va final pga den KAN muteras men ej peka på en ny lista (objekt) efter den initierats
    private final List<Plant> plants; // Skapar pekare

    // Icons in the GUI that never Change
    private final ImageIcon plantIcon = new ImageIcon("img/plant.png");


    // Konstruktor
    public FoodHotelAppen() {
        plants = new ArrayList<>(); // pekar nu i minnet där data för ett arrayList objekt förvaras

        // Lägger in plantorna vi skall jobba med i arrayListan
        addPlants();

        // Ingång i programmet
        menuHandler();
    }

    // Skapar upp en lista med Plants som vi kan jobba med för sökningar av användaren.
    public void addPlants() {
        plants.add(new Cactus("Igge", 0.2));
        plants.add(new Palm("Laura", 5));
        plants.add(new FlyTrap("MeatLoaf", 0.7));
        plants.add(new Palm("Putte", 1.0));
    }

    // Ritar ut Menu Prompt, "Välkomst menyn"
    private int menuPrompt() {
        Object[] options = { "Show all plants in the system", "Search", "Exit"};
        return JOptionPane.showOptionDialog(null, "Welcome to Alex Plant Hotel Menu", "Alex Plant Hotel App", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, plantIcon, options, null);
    }


    // Ger random bild varje gång för skojs skull :)
    private void errorPrompt(String plantName) {
        // Genererar en random error Icon
        ImageIcon errorIcon = new RandomImageGenerator().generateRandomErrorImg();

        Object[] options = { "Okay im sorry!"};
        String message = "We dont have a plant named " + plantName;
        Object defaultValueWhenPressedEnter = options[0]; // Så vi kan klicka enter istället för att klicka på knappen, den tar in en Object[]
        JOptionPane.showOptionDialog(null, message, "Plant not found", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, errorIcon, options, defaultValueWhenPressedEnter);
    }


    private void showResult(Plant plant) {
        // Genererar en random cat icon
        ImageIcon foodIcon = new RandomImageGenerator().generateRandomCatImg();

        Object[] options = { "mmm.. Tasty!"};
        String message = "This plant needs " + plant.calcNutrition() + " litres of " + plant.getFoodTypen();
        Object defaultValueWhenPressedEnter = options[0];
        JOptionPane.showOptionDialog(null, message, "Plant Food", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, foodIcon, options, defaultValueWhenPressedEnter);
    }


    // Switch sats som skickar oss vidare till de metoder vi gjorde i menuPrompt()
    private void menuHandler() {
        while (true) {
            int choice = menuPrompt();
            switch (choice) {
                case 0 -> message(getAllPlantNames());
                case 1 -> handleInput();
                case 2, -1 -> System.exit(1337);
            }
        }
    }

    private String getAllPlantNames() {
        StringBuilder sb = new StringBuilder();
        for(Plant plant : plants) {
            sb.append(plant.getName()).append("\nHeight: ").append(plant.getHeightInMeter()).append(" meters").append("\n\n");
        }
        return sb.toString();
    }


    private String userInputDialog() {
        while (true) {
            String input = JOptionPane.showInputDialog("What plant do you want to calculate food for?");

            if (input == null) {
                menuHandler(); // Klickar man cancel så blir de null och i DETTA fall avser vi att personen vill gå tillbaka till huvudmenyn
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
    private void handleInput() {
        while(true) {
                String plantName = userInputDialog();
                try {
                    Plant currentPlant = getPlantByNameElseThrow(plantName);
                    // Dynamiskt skriver ut mängd och mat typ, inte hårdkodat!
                    //message("This plant needs " + currentPlant.calcNutrition() + " litres of " + currentPlant.getFoodTypen());
                    showResult(currentPlant);
                    break;
                } catch (NoSuchElementException e) {
                    errorPrompt(plantName);
                }
            }
    }

    // Öppnar upp en ström på plantListan
    // Använder den String som man skickade in som input och löper genom plants listan för att hitta match
    // Vid första match -> returnerar plantans objekt så vi kan jobba med objektet senare
    private Plant getPlantByNameElseThrow(String plantName) {
        return plants.stream()
                .filter(plant -> plant.getName().equalsIgnoreCase(plantName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException());
    }

}
