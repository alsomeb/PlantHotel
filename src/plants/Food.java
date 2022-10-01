package plants;

public enum Food {
    // Använder dessa Konstanter för mattematiska beräkningar för plantorna
    TAPWATER("Tap Water", 0.5, 0),
    PROTEINDRINK("Protein Drink", 0.1, 0.2),
    MINERALWATER("Mineral Water", 0.02, 0);

    // Finns Getters för värden, valde att kapslat in denna data och använda respektive getMetod()
    private final String foodName;
    private final double baseAmount;
    private final double multiplyAmount;

    Food(String foodName, double baseAmount, double multiplyAmount) {
        this.foodName = foodName;
        this.baseAmount = baseAmount;
        this.multiplyAmount = multiplyAmount;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public double getMultiplyAmount() {
        return multiplyAmount;
    }


}
