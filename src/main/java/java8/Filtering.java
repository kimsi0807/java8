package java8;

import java.util.Arrays;
import java.util.List;
import static java8.Dish.menu;
import static java.util.stream.Collectors.toList;

public class Filtering {

	public static void main(String...args) {
		//filter
		List<Dish> listVegetarianMenu = 
				menu.stream()
				.filter(Dish::isVegetarian)
				.collect(toList());
		listVegetarianMenu.forEach(System.out::println);
		
		//distinct
		List<Integer> numberList = Arrays.asList(1,2,1,3,3,2,4);
		numberList.stream()
			.filter(i -> i % 2 == 0)
			.distinct()
			.forEach(System.out::println);
		
		//limit
		List<Dish> listLimits = 
				menu.stream()
				.filter(a -> a.getCalories() >300 )
				.limit(3)
				.collect(toList());
		
		listLimits.forEach(System.out::println);
		
		//skip
		List<Dish> listSkip = 
				menu.stream()
				.filter(d -> d.getCalories() >300)
				.skip(3)
				.collect(toList());
		listSkip.forEach(System.out::println);
		
				
		
		
	}
}
