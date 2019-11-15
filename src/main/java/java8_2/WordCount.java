package java8_2;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * <pre> 
 * WordCount.java
 * </pre>
 *
 * @author SEOL
 * @date : 2018. 12. 17.
 * @version : 
 * 
 */
public class WordCount {

	public WordCount() {
		// TODO Auto-generated constructor stub
	}

	public static final String SENTENCE =  
			" Nel   mezzo del cammin  di nostra  vita " +
            "mi  ritrovai in una  selva oscura" +
            " che la  dritta via era   smarrita ";
	
	public static void main(String[] args) {
	//	Spliterator<Character> spliterator = new wo
		
		
		
	}
	private static class WordCounterSpliterator implements Spliterator<Character>{

		private final String string;
		private int currentChar = 0;
		
		 public WordCounterSpliterator(String string) {
			// TODO Auto-generated constructor stub
			 this.string = string;
		}
		@Override
		public int characteristics() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long estimateSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean tryAdvance(Consumer<? super Character> action) {
			// TODO Auto-generated method stub
			action.accept(string.charAt(currentChar));
			return currentChar < string.length();
		}

		@Override
		public Spliterator<Character> trySplit() {
			// TODO Auto-generated method stub
			
			return null;
		}
		
	}
}
