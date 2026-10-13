
public class s {
    public void proc(String n, int s, double p) {
        if (n != null) {
            if (!n.isEmpty()) {
                if (s > 0) {
                    if (p > 0.0) {
                        System.out.println("Processing " + n);
                        double d = 0.0;
                        if (p > 100.0) {
                            d = p * 0.1;
                        }
                        System.out.println("Discount: " + d);
                    } else {
                        System.out.println("Invalid price");
                    }
                } else {
                    System.out.println("Invalid stock");
                }
            }
        }
    }
}