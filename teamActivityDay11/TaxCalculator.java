@FunctionalInterface
public interface TaxCalculator {
    double calculate(double amount);

    static double applyTax(double amount, int category) {
        TaxRate taxRate = TaxRate.fromCategory(category);
        TaxCalculator calculator = amt -> amt * (1 + taxRate.getRate());
        return calculator.calculate(amount);
    }
}
