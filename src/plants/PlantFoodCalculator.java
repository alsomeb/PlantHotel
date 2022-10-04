package plants;

public interface PlantFoodCalculator {
    // Polymorfism Interface
    // Metod som overrides i Plants subklasser då mattematisk algoritm för nutrition är olika i varje planta.
    // När jag passar in objektet med interface metoden så blir de samma metod för alla subklasser men olika svar
    double calcNutrition();
}
