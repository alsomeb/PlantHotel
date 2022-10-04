package PlantTest;

import org.junit.jupiter.api.Test;
import plants.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlantTests {

    // Tester för alla olika plantor vi har i vårat program, Cactus, Palm, FlyTrap


    // Metoden används för testerna nedan, så vi inte får fel när vi kör olika tester med decimaler
    // Tex 25.9 och 25.9000001 == FEL
    // Rundar upp till närmsta andra decimal så blir det inte fel i testerna
     double formatDoubleToOneDecimal(double number) {
        BigDecimal bg = new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
        return bg.doubleValue();
    }


    @Test
    void testCactusCalcNutritionReturnsCorrectValue() {
        // Polymorfism Interface
        // Vi kommer åt alla metoder som finns i vårat interface som Cactus implementerar, behöver ingen annan onödig data för testerna, spara på minnet!
        PlantFoodCalculator cactusCalculator = new Cactus("Igge",0.2);
        double expected = 0.02;
        double target = formatDoubleToOneDecimal(cactusCalculator.calcNutrition());
        assertEquals(expected, target);
    }

    @Test
    void testPalmCalcNutritionReturnsCorrectValue() {
        PlantFoodCalculator palmCalculator = new Palm("Laura",5);
        double expected = 2.5;
        double target = formatDoubleToOneDecimal(palmCalculator.calcNutrition());
        assertEquals(expected, target);
    }

    @Test
    void testFlyTrapCalcNutritionReturnsCorrectValue() {
        PlantFoodCalculator flyTrapCalculator = new FlyTrap("Meatloaf",0.7);
        double expected = 0.24;
        double target = formatDoubleToOneDecimal(flyTrapCalculator.calcNutrition());
        assertEquals(expected, target);
    }

    @Test
    void testFlyTrapCalcNutritionReturnsCorrectValueWithABigHeight(){
         PlantFoodCalculator flyTrapCalculator = new FlyTrap("Big FlyTrap", 129);
         double expected = 25.9;
         double target = formatDoubleToOneDecimal(flyTrapCalculator.calcNutrition());
         assertEquals(expected, target);
    }

    // Extra tester
    @Test
    void testGetFoodOnCactusReturnsMineralWater() {
        Plant cactus = new Cactus("Test", 3);
        Food expected = Food.MINERALWATER;
        assertEquals(expected, cactus.getFood());
    }

    @Test
    void testGetFoodOnPalmReturnsTapWater() {
        Plant palm = new Palm("Test", 3);
        Food expected = Food.TAPWATER;
        assertEquals(expected, palm.getFood());
    }

    @Test
    void testGetFoodOnFlyTrapReturnsProteinDrink() {
        Plant flyTrap = new FlyTrap("Test", 3);
        Food expected = Food.PROTEINDRINK;
        assertEquals(expected, flyTrap.getFood());
    }
}
