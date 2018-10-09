package java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static java8.Dish.menu;

public class NumericStream {
	
	public static void main(String...args) {
		List<Integer> numberList = Arrays.asList(3,4,5,1,2);
		
		Arrays.stream(numberList.toArray())
			.forEach(System.out::println);
		
		//Stream.mapToInt()
		//Stream.sum()
		int calories = menu.stream()
					.mapToInt(Dish::getCalories)
					.sum();
		System.out.println(calories);
		
		//Stream.max()
		OptionalInt optionalIntMax = menu.stream()
									.mapToInt(Dish::getCalories)
									.max();
		
		int max;
		if(optionalIntMax.isPresent()) {
			max = optionalIntMax.getAsInt();
		}else {
			max = 1;
		}
		System.out.println(max);
		
		IntStream evenNumbers = IntStream.rangeClosed(1, 10)
										.filter(i -> i%2 ==0);
		System.out.println(evenNumbers.count());
		
		
		
		
	}
}
