public enum TaxRate {
    LOW(0.05),
    MEDIUM(0.10),
    HIGH(0.15);

    private final double rate;

    TaxRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public static TaxRate fromCategory(int category) {
        switch (category) {
            case 1:
                return LOW;
            case 2:
                return MEDIUM;
            case 3:
                return HIGH;
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }
    }
}
