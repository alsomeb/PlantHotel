package plants;

public interface PlantFoodCalculator {
    // Metod som overrides i Plants subklasser då mattematisk algoritm för nutrition är olika i varje planta.
    double calcNutrition();
    String getFoodType();
}
