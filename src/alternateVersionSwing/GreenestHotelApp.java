package alternateVersionSwing;
import plants.Plant;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GreenestHotelApp extends JFrame {
    private final Header header;
    private final Footer footer;
    private final Body body;

    private final JButton exitButton;
    private final JButton showAllPlantsButton;


    public GreenestHotelApp() {
        this.setSize(1000, 800);
        this.setTitle("Greenest Plant Hotel App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        header = new Header();
        body = new Body();
        footer = new Footer();

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

    private void addPlantsInfoToBody() {
        // Hämta "DB" från Service
        List<Plant> allPlants = GreenestHotelAppService.getAllPlants();

        for(Plant plant : allPlants) {
            PlantInfo plantInfo = new PlantInfo(); // Skickar vidare listan
            plantInfo.setPlantName(plant.getName());
            body.add(plantInfo);
        }
    }
}
