package java8_2;

import java.util.*;
import static java.util.stream.Collectors.toList;
import static java8_2.Dish.menu;

import java.util.Arrays;
import java.util.List;

public class Filtering {

	List<Dish> vegeMenu = 
			menu.stream()
				.filter(Dish::isVegetarian)
				.collect(toList());
	
	vegeMenu.forEach(System.out::println);
	
	List<Integer> list = Arrays.asList(1,2,3,4,5);
	list.stream()
		.filter(i -> i % 2 == 0)
		.skip(2)
		.limit(3)
		.distinct()
		.forEach(System.out::println);
	
	
	
	
	
}
