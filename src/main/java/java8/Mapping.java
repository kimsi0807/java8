package java8;

import java.util.Arrays;
import java.util.List;

import static java8.Dish.menu;
import static java.util.stream.Collectors.toList;
public class Mapping {

	public static void main(String...args) {
		
		//map
		List<String> dishNameList = menu.stream()
					.map(d -> d.getName())
					.collect(toList());
		System.out.println(dishNameList);
		
		List<String> words = Arrays.asList("haha","hoho");
		List<Integer> list = words.stream()
							.map(String::length)
							.collect(toList());
		System.out.println(list);
		
		//flatMap
		words.stream()
			.flatMap(a -> Arrays.stream(a.split("")))
			.distinct()
			.forEach(System.out::println);
		
		List<Integer> numberList = Arrays.asList(1,2,3,4);
		List<Integer> numberList2 = Arrays.asList(6,7,8);
		
		List<int[]> pairs = numberList.stream()
						.flatMap(i -> numberList2.stream()
											.map(j -> new int[] {i,j})
								)
	//					.filter(a -> (a[0] + a[1]) % 3 == 0)
						.collect(toList());
		
		pairs.forEach(a -> System.out.println(a[0]+","+a[1]));
	}
}
