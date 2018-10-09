package java8;

import static java8.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {

	public static void main(String...args) {
		
		List<Integer> intList = Arrays.asList(3,4,5,1,2);
		int sum = intList.stream().reduce(0, (a,b)->a+b);
		System.out.println(sum);
		
		int sum2 = intList.stream().reduce(1,Integer::sum);
		System.out.println(sum2);
		
		int max = intList.stream().reduce(0, Integer::max);
		System.out.println(max);
		
		Optional<Integer> min = intList.stream().reduce(Integer::min);
		System.out.println(min.get());
		
		int calories = menu.stream()
					.map(Dish::getCalories)
					.reduce(0, Integer::sum);
		System.out.println(calories);
	}
}
