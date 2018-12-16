package java8_2;

import static java8_2.Dish.menu;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
/**
 * <pre>
 * java8_2
 * Summarizing.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */
public class Summarizing {

	public Summarizing() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		menu.stream().collect(counting());
		
		menu.stream().mapToInt(Dish::getCalories).max().getAsInt();
		menu.stream().collect(reducing((a,b)->a.getCalories()>b.getCalories()?a:b));
		
		menu.stream().collect(reducing(
				maxBy(
						comparingInt(Dish::getCalories)
						)
				)
				);
		menu.stream().collect(summingInt(Dish::getCalories));
		menu.stream().collect(averagingInt(Dish::getCalories));
		menu.stream().collect(summarizingInt(Dish::getCalories));
		menu.stream().map(Dish::getName).collect(joining());
		menu.stream().map(Dish::getName).collect(joining(" "));
		
		
		
		
	}

}
