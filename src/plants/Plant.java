package plants;

public abstract class Plant implements PlantFoodCalculator {

    // Inkapslad data med protected pga enklare TDD, medans metoder är publika för användning
    protected String name;
    protected double heightInMeter;

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

    public void setName(String name) {
        this.name = name;
    }

    public double getHeightInMeter() {
        return heightInMeter;
    }

    public void setHeightInMeter(double heightInMeter) {
        this.heightInMeter = heightInMeter;
    }



}
