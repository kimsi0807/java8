package java8_2;

import java.util.Arrays;
import java.util.List;

import static java8_2.Dish.menu;
import static java.util.stream.Collectors.toList;

public class Mapping {

	List<String> dishNames = menu.stream()
								.map(Dish::getName)
								.collect(toList());
	
	List<String> words = Arrays.asList("hell","go");
	List<Integer> wordLengths = words.stream()
									.map(String::length)
									.collect(toList());
	
	words.stream()
			.flatMap((String a) -> Arrays.stream(a.split("")))
			.distinct()
			.forEach(System.out::println);
	
    words.stream()
    .flatMap((String line) -> Arrays.stream(line.split("")))
    .distinct()
    .forEach(System.out::println);
	
	List<Integer> numbers1 = Arrays.asList(1,2,3,4);
	List<Integer> numbers2 = Arrays.asList(3,4,5);
	
	List<int[]> pairs = 
						numbers1.stream()
								.flatMap((Integer i) -> numbers2.stream()
																.map((Integer j) -> 
																new int[]{i,j})
										)
								.filter(pair -> (pair[0] + pair[1]) % 3 ==0)
								.collect(toList());
	
}
