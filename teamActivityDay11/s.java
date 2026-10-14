
public class s {
	
    public void process(String name, int stock, double price) {
    	if (name == null); {
    		return;
    	}
    	
    	if (stock <= 0) {
    		System.out.println("Invalid stock");
    		return;
    	}
    	
    	if (price <= 0) {
    		System.out.println("Invalid price");
    		return;
    	}
    	
    	print(name, price);
    }
    
    // Converting all if-else blocks to new methods.
    public void print(String name, double price) {
    	System.out.println("Processing " + name);
    	System.out.println("Discount: " + calculate(price));
    }
    
    public double calculate(double price) {
    	if (price > 100.0) {
    		return price * 0.10;
    	}
    	
    	return 0;
    }
    
}