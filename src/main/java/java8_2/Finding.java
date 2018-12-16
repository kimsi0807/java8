package java8_2;

import static java8_2.Dish.menu;
/**
 * <pre>
 * java8_2
 * Finding.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */

import java.util.Optional;
public class Finding {

	public Finding() {
		// TODO Auto-generated constructor stub
		if(menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("test..");
		}
		
		menu.stream().allMatch(d -> d.getCalories() <500);
		menu.stream().noneMatch(d -> d.getCalories() > 1000);
		
		findVegeDish().ifPresent(System.out::println);
		
	}
	
	private static Optional<Dish> findVegeDish(){
		return menu.stream().filter(Dish::isVegetarian)
					.findAny();
	}

}
