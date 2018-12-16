package java8_2;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <pre>
 * java8_2
 * Laziness.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */
public class Laziness {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4);
		List<Integer> a = numbers.stream()
									.filter(n -> {
										System.out.println("tes.t..");
										return n % 2 == 0;
									})
									.map(n -> {
										System.out.println("mapping..");
										return n * n;
									})
									.limit(2)
									.collect(toList());
	}

}
