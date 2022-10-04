package frontend.alternateVersion;

import plants.Plant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.NoSuchElementException;

public class Footer extends JPanel {
    private final JButton showAllPlantsButton;

    private final JButton quickSearchPlantButton;
    private final JButton exitButton;

    private final List<Plant> plantsList;

    public Footer(List<Plant> plantList) {
        this.plantsList = plantList;

        this.setPreferredSize(new Dimension(1000, 180));
        this.setBackground(new Color(0xB7354E33, true));


        this.add(Box.createVerticalStrut(100)); // Margin Top på knapparna
        // Buttons
        showAllPlantsButton = new JButton("Toggle Show All Plants");
        showAllPlantsButton.setFocusable(false);
        showAllPlantsButton.setFont(new Font("Sans-serif", Font.BOLD, 20));
        this.add(showAllPlantsButton);

        // Gap between buttons
        this.add(Box.createHorizontalStrut(20));

        quickSearchPlantButton = new JButton("Quick search plant name");
        quickSearchPlantButton.setFocusable(false);
        quickSearchPlantButton.setFont(new Font("Sans-serif", Font.BOLD, 20));
        this.add(quickSearchPlantButton);

        // Gap between buttons
        this.add(Box.createHorizontalStrut(20));

        exitButton = new JButton("Exit");
        exitButton.setFocusable(false);
        exitButton.setFont(new Font("Sans-serif", Font.BOLD, 20));
        this.add(exitButton);

        addListeners();
    }

    private void addListeners() {
        quickSearchPlantButton.addActionListener(e -> handleInput());
    }

    private void handleInput() {
        while(true) {
            String plantName = userInputDialog();
            try {
                Plant currentPlant = getPlantByNameElseThrow(plantName);
                JOptionPane.showMessageDialog(null, currentPlant.getName() + " drinks " + currentPlant.calcNutrition() + " liters of " + currentPlant.getFoodTypen() + " per day");
                break;
            } catch (NoSuchElementException e) {
                JOptionPane.showMessageDialog(null, plantName + " doesnt exist in our system");
            }
        }
    }

    private String userInputDialog() {
        while (true) {
            String input = JOptionPane.showInputDialog("What plant do you want to calculate food for?");

            if (input == null) {
                continue;
            } else if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Får ej vara tomt!");
                continue;
            }
            return input;
        }
    }

    private Plant getPlantByNameElseThrow(String plantName) {
        return plantsList.stream()
                .filter(plant -> plant.getName().equalsIgnoreCase(plantName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException());
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getShowAllPlantsButton() {
        return showAllPlantsButton;
    }

}
