import java.util.Optional;

// Utility class to handle tax calculations cleanly using Lambdas and Optional
public class TaxCalculator {

    // Functional interface representing a tax calculation strategy
    @FunctionalInterface
    public interface TaxOperation {
        double apply(double amount, double multiplier);
    }

    // Calculates total amount by looking up the tax rate enum and applying a lambda operation
    public static double calculateTotal(double amount, int typeCode) {
        TaxRate rate = Optional.ofNullable(TaxRate.fromCode(typeCode))
                               .orElse(TaxRate.EXEMPT);

        TaxOperation calc = (amt, mult) -> amt * mult;

        return calc.apply(amount, rate.getMultiplier());
    }
}
