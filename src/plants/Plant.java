package plants;

public abstract class Plant implements PlantFoodCalculator {

    // Inkapslad data med protected, dvs åtkomst i samma paket och i subklasser
    // Valde protected eftersom då kommer jag åt food instansvariabel i subklassernas konstruktor och inte behöver göra en setter.
    // Namn & höjd kan va final i detta program då vi inte kommer att ändra deras värde
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
    // Abstrakt metod som returnerar växternas Mattyp
    // samma metod för alla subklasser men olika implementeringar och svar.
    public abstract String getFoodTypen();


    // Getters
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
