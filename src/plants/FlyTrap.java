package plants;

public class FlyTrap extends Plant {

    public FlyTrap(String name, double heightInMeter) {
        super(name, heightInMeter);
    }


    // Polymorfism interface
    // Olika matematiska formler beroende på planta
    // Typen av Mat
    @Override
    public double calcNutrition() {
        // Mindre hardcoded mer dynamiskt, använder ENUMEN för mattematiska beräkningen av mat
        return Food.PROTEINDRINK.getBaseAmount() + (Food.PROTEINDRINK.getMultiplyAmount() * getHeightInMeter());
    }

    @Override
    public String getFoodType() {
        return Food.PROTEINDRINK.getTyp();
    }


}
