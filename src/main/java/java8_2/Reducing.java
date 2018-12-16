package java8_2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java8_2.Dish.menu;
/**
 * <pre>
 * java8_2
 * Reducing.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */
public class Reducing {

	public Reducing() {
		// TODO Auto-generated constructor stub
		List<Integer> numbers = Arrays.asList(3,4,5);
		int sum1 = numbers.stream()
						.reduce(0, (a, b) -> a + b);
		
		int sum2 = numbers.stream()
							.reduce(0, Integer::sum);
		
		//int max = numbers.stream()
		//					.reduce(0, (a, b )->a > b ? a : b);
		
		int max2 = numbers.stream()
							.reduce(0, (a, b) -> Integer.max(a,b));
		Optional<Integer> max3 = numbers.stream().reduce(Integer::min);
		
		int calSum = menu.stream()
							.map(Dish::getCalories)
							.reduce(0, Integer::sum);
		

		
	}

}
