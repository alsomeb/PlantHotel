package alternateVersionSwing;

import plants.Cactus;
import plants.FlyTrap;
import plants.Palm;
import plants.Plant;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GreenestHotelAppService {
    // Här Ligger statiska Hjälpmetoder som "GreenestHotelApp" återanvänder för att minska kod duplicering

    // Kan agera som "DB"
    private static final List<Plant> allPlants = new ArrayList<>(
            List.of(new Cactus("Igge", 0.2),
                    new Palm("Laura", 5),
                    new FlyTrap("MeatLoaf", 0.7),
                    new Palm("Putte", 1.0))
    );

    public static List<Plant> getAllPlants() {
        return allPlants;
    }


    // Sök efter planta i "DB"
    public static Plant getPlantByNameElseThrow(String plantName) {
        return allPlants.stream()
                .filter(plant -> plant.getName().equalsIgnoreCase(plantName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException());
    }


    // Dynamisk message metod
    public static void messageBox(String text) {
        JOptionPane.showMessageDialog(null, text);
    }


}
