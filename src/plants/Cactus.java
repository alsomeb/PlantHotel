package plants;

public class Cactus extends Plant {

    public Cactus(String name, double heightInMeter) {
        super(name, heightInMeter);
    }


    // Polymorfism interface
    // Olika matematiska formler beroende på planta
    // Typen av Mat
    @Override
    public double calcNutrition() {
        return Food.MINERALWATER.getBaseAmount(); // Behöver inte gångras med längd eller något annat här !
    }

    @Override
    public String getFoodType() {
        return Food.MINERALWATER.getTyp();
    }


}
