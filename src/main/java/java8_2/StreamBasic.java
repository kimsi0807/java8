package java8_2;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.Comparator;

public class StreamBasic {

	public static List<String> getLowCalNames(List<Dish> dishes){
		return dishes.stream()
				.filter(a -> a.getCalories() < 400)
				.sorted(comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(toList());
		
		Collections.sort(menu, new Comparator<Dish>() {
			@Override
			public int compare(Dish d1, Dish d2) {
				// TODO Auto-generated method stub
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		
	}
	
	public static void main(String...args) {
		getLowCalNames(Dish.menu).forEach(System.out::println);
	}
}
