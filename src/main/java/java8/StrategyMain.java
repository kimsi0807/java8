package java8;

import javax.xml.bind.Validator;

public class StrategyMain {

	interface ValidationStrategy{
		public boolean execute(String s);
	}
	static private class IsAllowLowerCase implements ValidationStrategy{
		@Override
		public boolean execute(String s) {
			// TODO Auto-generated method stub
			return s.matches("[a-z]+");
		}
	}
	static private class IsNumeric implements ValidationStrategy{
		@Override
		public boolean execute(String s) {
			// TODO Auto-generated method stub
			return s.matches("\\d+");
		}
	}
	
	//////////////////////
	static private class Validator{
		private final ValidationStrategy validationStrategy;
		public Validator(ValidationStrategy v) {
			this.validationStrategy = v;
		}
		public boolean validate(String s) {
			return validationStrategy.execute(s);
		}
	}
	public static void mian(String... args) {
		Validator lowerValidator = new Validator(new IsAllowLowerCase());
		lowerValidator.validate("AA");
		Validator v2 = new Validator(new IsNumeric());
		v2.validate("22");
		
		//lambda
		Validator validator = new Validator((String s) -> s.matches("[a-z]+"));
		System.out.println(validator.validate("AA"));
		Validator v3 = new Validator((String s) -> s.matches("\\d+"));
		v3.validate("22");
				
				
				
				
				
				
				
				
				
				
				
				
				
	}
}
