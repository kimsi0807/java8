package java8_2;

import static java8_2.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * <pre>
 * java8_2
 * NumericStream.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */
public final class NumericStream {

	public NumericStream() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3);
		Arrays.stream(numbers.toArray()).forEach(System.out::println);
		
		int sum = menu.stream().mapToInt(Dish::getCalories)
							.sum();
		OptionalInt maxCal = menu.stream().mapToInt(Dish::getCalories).max();
		
		if(maxCal.isPresent()) {
			int max = maxCal.getAsInt();
		}
		
		IntStream.rangeClosed(1, 100)
				.filter(n -> n%2==0)
				.count();
	}
}
