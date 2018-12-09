package java8;

import java.util.function.Consumer;

public class OnlineBankingLambda {

	//dummy for test..
	static private class Customer{}
	//dummy for test
	static private class Database{
		static Customer getCustomerWithId(int id) {
			return new Customer();
		}
	}
	
	public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
		Customer customer = Database.getCustomerWithId(id);
		makeCustomerHappy.accept(customer);
	}
	
	public static void main(String... args) {
		new OnlineBankingLambda().processCustomer(123, (Customer c) -> 
		System.out.println("hihi"));
	}
		
}
