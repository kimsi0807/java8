package java8_2;

import static java8_2.Dish.menu;
import static java.util.stream.Collectors.*;
/**
 * <pre>
 * java8_2
 * Reducing2.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */
public class Reducing2 {

	public Reducing2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		menu.stream().collect(reducing(0, Dish::getCalories, (a,b)-> a+b)
				);
		
		menu.stream().collect(reducing(0, Dish::getCalories,Integer::sum));
		menu.stream().mapToInt(Dish::getCalories).sum();
		menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
		
	}
}
