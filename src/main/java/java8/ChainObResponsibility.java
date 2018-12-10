package java8;

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
	}
}
