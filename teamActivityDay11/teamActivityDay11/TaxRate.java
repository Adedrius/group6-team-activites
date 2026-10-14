// Enum representing the different tax rate tiers and their corresponding multipliers
public enum TaxRate {
    // Defined tax tiers: (Type Code, Percentage Multiplier)
    STANDARD(1, 1.05), // Code 1 = 5% tax
    PREMIUM(2, 1.10),  // Code 2 = 10% tax
    LUXURY(3, 1.15),   // Code 3 = 15% tax
    EXEMPT(0, 1.00);   // Code 0 = 0% tax (no increase)

    // Field to store the numerical category code (1, 2, 3)
    private final int typeCode;

    // Field to store the tax multiplier ( 1.05)
    private final double multiplier;

    // Enum constructor to initialize each rate tier with its code and multiplier
    TaxRate(int typeCode, double multiplier) {
        this.typeCode = typeCode;
        this.multiplier = multiplier;
    }

    // Getter method to retrieve the multiplier for calculations
    public double getMultiplier() {
        return multiplier;
    }

    // Helper method to look up a TaxRate enum constant by its numerical code
    public static TaxRate fromCode(int code) {
        // Loop through all enum values to find a matching typeCode
        for (TaxRate rate : values()) {
            if (rate.typeCode == code) {
                return rate; // Return matching tax rate tier
            }
        }
        // Default to EXEMPT (1.00x) if the code is unrecognized or not found
        return EXEMPT;
    }
}
