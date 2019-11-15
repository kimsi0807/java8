package java8_2;

import java.util.stream.LongStream;

/**
 * <pre> 
 * SubsetsMain.java
 * </pre>
 *
 * @author SEOL
 * @date : 2018. 12. 17.
 * @version : 
 * 
 */
public class SubsetsMain {
	public static void main(String[] args) {
		LongStream.rangeClosed(1, 100)
					.reduce(1,(a, b)-> a+b);
	}
}
