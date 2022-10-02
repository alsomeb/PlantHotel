package plants;

public abstract class Plant implements PlantFoodCalculator {

    // Inkapslad data med protected, dvs åtkomst i samma paket och i subklasser
    // namn & höjd kan va final i detta program då vi inte kommer att ändra deras värde
    protected final String name;

    protected final double heightInMeter;

    // Enum typ av food plantan skall ha
    protected Food food;


    // Constructor
    public Plant(String name, double heightInMeter) {
        this.name = name;
        this.heightInMeter = heightInMeter;
    }


    // Polymorfism
    // Abstrakt metod som returnerar växternas Mattyp, olika beroende på planta!
    public abstract String getFoodTypen();


    // Getters n Setters
    public String getName() {
        return name;
    }


    public double getHeightInMeter() {
        return heightInMeter;
    }


    // Denna Används för tester, och abstrakta metoden 'getFoodTypen' ovan returnerar en String för GUI
    public Food getFood() {
        return food;
    }
}
