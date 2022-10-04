package plants;

public class Palm extends Plant {

    public Palm(String name, double heightInMeter) {
        super(name, heightInMeter);
        // Vi vet vad en Palm skall ha för mat så vi ger objekten direkt typen av mat med ENUMEN
        // Annars finns risk när vi instansierar att de blir fel Mat Typ
        food = Food.TAPWATER;
    }


    // Polymorfism interface
    // Olika matematiska formler beroende på planta
    @Override
    public double calcNutrition() {
        // använder food ENUMEN för mattematiska beräkningen av mat
        return food.getBaseAmount() * getHeightInMeter();
    }

    // Polymorfism Abstract metod
    // Abstract metod från superklassen som skriver ut vilken typ av mat plantan skall ha
    @Override
    public String getFoodTypen() {
        return food.getFoodName();
    }

}
