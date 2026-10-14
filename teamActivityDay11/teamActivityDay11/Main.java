public class Main {
    public static void main(String[] args) {
        double baseAmount = 100.0;

        // Test Type 1 (5% tax - expected 105.0)
        System.out.println("Type 1 (Standard): " + TaxCalculator.calculateTotal(baseAmount, 1));

        // Test Type 2 (10% tax - expected 110.0)
        System.out.println("Type 2 (Premium): " + TaxCalculator.calculateTotal(baseAmount, 2));

        // Test Type 3 (15% tax - expected 115.0)
        System.out.println("Type 3 (Luxury): " + TaxCalculator.calculateTotal(baseAmount, 3));

        // Test Unknown Code (0% tax - expected 100.0)
        System.out.println("Unknown Code (Exempt): " + TaxCalculator.calculateTotal(baseAmount, 99));
    }
}
