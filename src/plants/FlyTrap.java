package plants;

public class FlyTrap extends Plant {

    public FlyTrap(String name, double heightInMeter) {
        super(name, heightInMeter);
        // Vi vet vad en FlyTrap skall ha för mat så vi ger objekten direkt typen av mat med ENUMEN
        // Annars finns risk när vi instansierar att de blir fel Mat Typ
        food = Food.PROTEINDRINK;
    }


    // Polymorfism interface
    // Olika matematiska formler beroende på planta
    @Override
    public double calcNutrition() {
        // använder food ENUMEN för mattematiska beräkningen av mat
        return food.getBaseAmount() + (food.getMultiplyAmount() * getHeightInMeter());
    }

    // Polymorfism Abstract metod
    // Abstract metod från superklassen som skriver ut vilken typ av mat plantan skall ha
    @Override
    public String getFoodTypen() {
        return food.getFoodName();
    }

}
