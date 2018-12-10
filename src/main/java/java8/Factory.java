package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Factory {

	static private interface Product{}
	static private class Loan implements Product{}
	static private class Stock implements Product{}
	static private class Bond implements Product{}
	
	final static private Map<String, Supplier<Product>> map = new HashMap<>();
	static {
		map.put("loan", Loan::new);
		map.put("stock", Stock::new);
	}
	
	static private class ProductFactory{
		public static Product createProduct(String name) {
			switch(name) {
			case "loan" : 
				return new Loan();
			case "stock" :
				return new Stock();
			default :
				throw new RuntimeException("No such prodcut"+name);
			}
		}
		//////
		public static Product createProductLambda(String name) {
			Supplier<Product> p = map.get(name);
			if(p != null) p.get();
			throw new RuntimeException("No Such product"+name);
		}
		
	}
	
	public static void main(String...args) {
		Product p1 = ProductFactory.createProduct("loan");
		
		Supplier<Product> loanSupplier = Loan::new;
		Product p2= loanSupplier.get();
		
		Product p3 = ProductFactory.createProductLambda("loan");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
