package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Stream {

	public static void main(String...args) {
		getLowCaloricDishesNameInJava7(Dish.menu).forEach(System.out::println);
		
		getLowCaloricDishesNameInJava8(Dish.menu).forEach(System.out::println);
	
	//	List<String> names = Arrays.asList(a)
	}
	
	public static List<String> getLowCaloricDishesNameInJava7(List<Dish> dishList){
		List<Dish> resultCalList = new ArrayList<>();
		List<String> resultRowColNameList = new ArrayList<>();
		
		for(Dish dish : dishList) {
			if(dish.getCalories() < 500) resultCalList.add(dish);
		}
		Collections.sort(resultCalList, comparing(Dish::getCalories));
		for(Dish dish : resultCalList) {
			resultRowColNameList.add(dish.getName());
		}
		return resultRowColNameList;
	}
	public static List<String> getLowCaloricDishesNameInJava8 (List<Dish> dishList){
		return dishList.stream()
			.filter(a -> a.getCalories() < 500)
			.sorted(comparing(Dish::getCalories))
			.map(Dish::getName)
			.collect(toList());
	}
}
