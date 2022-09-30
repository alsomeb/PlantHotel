package plants;

public enum Food {
    // Använder dessa Konstanter för mattematiska beräkningar
    TAPWATER("Tap Water", 0.5, 0),
    PROTEINDRINK("Protein Drink", 0.1, 0.2),
    MINERALWATER("Mineral Water", 0.02, 0);

    private final String typ;
    private final double baseAmount;

    private final double multiplyAmount;

    Food(String typ, double baseAmount, double multiplyAmount) {
        this.typ = typ;
        this.baseAmount = baseAmount;
        this.multiplyAmount = multiplyAmount;
    }

    public String getTyp() {
        return typ;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public double getMultiplyAmount() {
        return multiplyAmount;
    }
}
