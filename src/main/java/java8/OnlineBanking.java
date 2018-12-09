package java8;

abstract class OnlineBanking {

	//dummy for test..
	static private class Customer{}
	//dummy for test
	static private class Database{
		static Customer getCustomerWithId(int id) {
			return new Customer();
		}
	}
	abstract void makeCustomerHappy(Customer c);
	
	public void processCustomer(int id) {
		Customer customer = Database.getCustomerWithId(id);
		makeCustomerHappy(customer);
		
	}
	
}
