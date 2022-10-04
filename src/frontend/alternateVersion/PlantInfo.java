package frontend.alternateVersion;

import plants.Plant;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PlantInfo extends JPanel {

    private final List<Plant> plantsList;
    private static int plantIdIncrementerCount = 0; // För Easy fix av plantsList Index!
    private final int plantId;
    private final JLabel plantName;
    private final JButton plantDescriptionButton;

    public PlantInfo(List<Plant> plantList) {
        plantId = plantIdIncrementerCount++; // Hämtar värdet sen ++ för nästa ID
        this.plantsList = plantList;

        this.setPreferredSize(new Dimension(40, 20));
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0xB7425F40, true));

        // Varje Plant har detta
        plantName = new JLabel();
        plantName.setPreferredSize(new Dimension(300, 20));
        plantName.setFont(new Font("Sans-serif", Font.BOLD, 20));
        plantName.setHorizontalAlignment(JLabel.CENTER);
        this.add(plantName, BorderLayout.CENTER);

        plantDescriptionButton = new JButton("Info");
        plantDescriptionButton.setPreferredSize(new Dimension(100,20));
        plantDescriptionButton.setFocusable(false);
        this.add(plantDescriptionButton, BorderLayout.EAST);

        addListeners();
    }

    private void addListeners() {
        plantDescriptionButton.addActionListener(e -> {
            Plant plant = plantsList.get(plantId);
            message(plant.getName() + " with a height of " + plant.getHeightInMeter() + " meters"
            + " drinks " + plant.calcNutrition() + " litres of " + plant.getFoodTypen() + " per day");
        });
    }

    public void setPlantName(String plantName) {
        this.plantName.setText(plantName);
    }


    // Dynamisk message metod som kan återanvändas
    private void message(String text) {
        JOptionPane.showMessageDialog(null, text);
    }
}
