public class Tool {
    public static double calc(double a, int t) {
        if (t == 1) {
            return a * 1.05;
        } else if (t == 2) {
            return a * 1.10;
        } else if (t == 3) {
            return a * 1.15;
        } else {
            return a;
        }
    }
}
