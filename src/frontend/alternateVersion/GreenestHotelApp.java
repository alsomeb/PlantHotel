package frontend.alternateVersion;

import plants.Cactus;
import plants.FlyTrap;
import plants.Palm;
import plants.Plant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GreenestHotelApp extends JFrame {
    private final List<Plant> plantsList;
    private final Header header;
    private final Footer footer;
    private final Body body;

    private final JButton exitButton;
    private final JButton showAllPlantsButton;


    public GreenestHotelApp() {
        plantsList = new ArrayList<>();
        populatePlantList();

        this.setSize(1000, 800);
        this.setTitle("Greenest Plant Hotel App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        header = new Header();
        body = new Body();
        footer = new Footer(plantsList);

        this.add(header, BorderLayout.NORTH);
        this.add(body, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        
        // Buttons från footer
        exitButton = footer.getExitButton();
        showAllPlantsButton = footer.getShowAllPlantsButton();
        
        // Event Listeners
        AddListeners();

        this.setVisible(true);
    }

    private void AddListeners() {
        exitButton.addActionListener(e -> System.exit(0));

        showAllPlantsButton.addActionListener(e -> {
                addPlantsInfoToBody();
                showAllPlantsButton.setEnabled(false);
                revalidate();
        });

    }

    private void populatePlantList() {
        plantsList.add(new Cactus("Igge", 0.2));
        plantsList.add(new Palm("Laura", 5));
        plantsList.add(new FlyTrap("MeatLoaf", 0.7));
        plantsList.add(new Palm("Putte", 1.0));
    }

    private void addPlantsInfoToBody() {
        for(Plant plant : plantsList) {
            PlantInfo plantInfo = new PlantInfo(plantsList); // Skickar vidare listan
            plantInfo.setPlantName(plant.getName());
            body.add(plantInfo);
        }
    }
}
