package java8;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainObResponsibility {

	static private abstract class ProcessingObject<T>{
		protected ProcessingObject<T> successor;
		
		public void setSuccessor(ProcessingObject<T> success) {
			this.successor = success;
		}
		
		abstract protected T handleWrok(T input);
		
		public T handle(T input) {
			T r = handleWrok(input);
			if(successor != null) {
				return successor.handle(r);
			}
			return r;
			
		}
	}
	
	static private class HeaderTextProcessing extends ProcessingObject<String>{
		@Override
		protected String handleWrok(String input) {
			// TODO Auto-generated method stub
			return "this is header ...";
		}
	}
	
	static private class SpellCheckProcessing extends ProcessingObject<String>{
		@Override
		protected String handleWrok(String input) {
			// TODO Auto-generated method stub
			return input.replace("aa", "bb");
		}
	}
	
	public static void main(String...args) {
		ProcessingObject<String> p1 = new HeaderTextProcessing();
		ProcessingObject<String> p2 = new SpellCheckProcessing();
		
		p1.setSuccessor(p2);
		String result1 = p1.handle("aa");
		System.out.println(result1);
		
		
		////
		UnaryOperator<String> headerProcessing = (String text) -> "aa"+text;
		UnaryOperator<String> spellCheckProcessing = (String text) -> text.replace("a", "B");
		
		Function<String, String> pipeline = headerProcessing.andThen(spellCheckProcessing);
		
		String result2 = pipeline.apply("aaa");
	}
}
