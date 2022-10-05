package alternateVersionSwing;

import plants.Plant;

import javax.swing.*;
import java.awt.*;
import java.util.NoSuchElementException;

public class Footer extends JPanel {
    private final JButton showAllPlantsButton;

    private final JButton quickSearchPlantButton;
    private final JButton exitButton;

    public Footer() {
        this.setPreferredSize(new Dimension(1000, 180));
        this.setBackground(new Color(0xB7354E33, true));


        this.add(Box.createVerticalStrut(100)); // Margin Top på knapparna

        // Buttons
        showAllPlantsButton = new JButton("Show All Plants");
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
                Plant currentPlant = GreenestHotelAppService.getPlantByNameElseThrow(plantName);
                GreenestHotelAppService.messageBox(currentPlant.getName() + " drinks " + currentPlant.calcNutrition() + " liters of " + currentPlant.getFoodTypen() + " per day");
                break;
            } catch (NoSuchElementException e) {
                GreenestHotelAppService.messageBox(plantName + " doesnt exist in our system");
            }
        }
    }

    private String userInputDialog() {
        while (true) {
            String input = JOptionPane.showInputDialog("What plant do you want to calculate food for?");

            if (input == null) {
                continue;
            } else if (input.isEmpty()) {
                GreenestHotelAppService.messageBox("Får ej vara tomt!");
                continue;
            }
            return input;
        }
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getShowAllPlantsButton() {
        return showAllPlantsButton;
    }

}
