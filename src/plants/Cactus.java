package plants;

public class Cactus extends Plant {

    public Cactus(String name, double heightInMeter) {
        super(name, heightInMeter);
        // Vi vet vad en Cactus skall ha för mat så vi ger objekten direkt typen av mat med ENUMEN
        // Annars finns risk när vi instansierar att de blir fel Mat Typ
        food = Food.MINERALWATER;
    }


    // Polymorfism interface
    // Olika matematiska formler beroende på planta
    @Override
    public double calcNutrition() {
        // Behöver inte gångras med längd eller något annat här !
        return food.getBaseAmount();
    }

    // Polymorfism
    // Abstract metod från superklassen som skriver ut vilken typ av mat plantan skall ha
    @Override
    public String getFoodTypen() {
        return food.getFoodName();
    }

}
