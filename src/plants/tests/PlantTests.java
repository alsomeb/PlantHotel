package plants.tests;
import org.junit.jupiter.api.Test;
import plants.Cactus;
import plants.FlyTrap;
import plants.Palm;
import plants.PlantFoodCalculator;

import static org.junit.jupiter.api.Assertions.*;
public class PlantTests {

    // Tester för alla olika plantor vi har i vårat program, Cactus, Palm, FlyTrap

    @Test
    void testCactusCalcNutritionReturnsCorrectValue() {
        // Polymorfism Interface
        // Vi kommer åt alla metoder som finns i vårat interface som Cactus implementerar, behöver ingen annan onödig data!
        PlantFoodCalculator cactusCalculator = new Cactus("Igge",0.2);
        double expected = 0.02;
        assertEquals(expected, cactusCalculator.calcNutrition());
    }

    @Test
    void testPalmCalcNutritionReturnsCorrectValue() {
        PlantFoodCalculator palmCalculator = new Palm("Laura",5);
        double expected = 2.5;
        assertEquals(expected, palmCalculator.calcNutrition());
    }

    @Test
    void testFlyTrapCalcNutritionReturnsCorrectValue() {
        PlantFoodCalculator flyTrapCalculator = new FlyTrap("Meatloaf",0.7);
        double expected = 0.24;
        assertEquals(expected, flyTrapCalculator.calcNutrition());
    }
}
