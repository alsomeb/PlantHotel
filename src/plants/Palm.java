package plants;

public class Palm extends Plant {

    public Palm(String name, double heightInMeter) {
        super(name, heightInMeter);
    }


    // Polymorfism interface
    // Olika matematiska formler beroende på planta
    // Typen av Mat
    @Override
    public double calcNutrition() {
        return Food.TAPWATER.getBaseAmount() * getHeightInMeter();
    }

    @Override
    public String getFoodType() {
        return Food.TAPWATER.getTyp();
    }


}
