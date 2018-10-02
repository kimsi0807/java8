package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FilterTest {

	@AllArgsConstructor
	@Setter
	@Getter
	@ToString
	public static class Apple{
		private int weight = 0;
		private String color = "";
		
	}
	public static void main(String ... args) {
		List<Apple> appleList = Arrays.asList(new Apple(80, "green")
				,new Apple(55, "red")
				,new Apple(44, "green"));
		
		List<Apple> greenApple0 = filterGreenApple(appleList);
		List<Apple> heavyApple0 = filterHeavyApple(appleList);
		
		// 1)
		List<Apple> greenApple1 = filterApples(appleList, FilterTest::isGreenApple);
		List<Apple> heavyApple1 = filterApples(appleList, FilterTest::isheavyApple);
		
		//2) functional interface...
		List<Apple> greenApples2 = filterApples(appleList, a-> "green".equals(a.getColor()));
		List<Apple> heavyApples2 = filterApples(appleList, a -> a.getWeight() > 150 );
		List<Apple> orApples = filterApples(appleList, a -> "black".equals(a.getColor()) ||
				a.getWeight() < 80 );
		
	}
	public static List<Apple> filterGreenApple(List<Apple> appleList){
		List<Apple> listResult = new ArrayList<>();
		for(Apple apple : appleList) {
			if("green".equals(apple.getColor())) {
				listResult.add(apple);
			}
		}
		return listResult;
	}
	public static List<Apple> filterHeavyApple(List<Apple> appleList){
		List<Apple> listResult = new ArrayList<>();
		for(Apple apple : appleList) {
			if(apple.getWeight() > 100) {
				listResult.add(apple);
			}
		}
		return listResult;
	}
	public static boolean isheavyApple(Apple apple) {
		return apple.getWeight() > 50;
	}
	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}
	public static List<Apple> filterApples(List<Apple> listApple, 
			Predicate<Apple> predicate){
		List<Apple> listResult = new ArrayList<>();
		for( Apple apple : listApple) {
			if(predicate.test(apple)) {
				listResult.add(apple);
			}
		}
		return listResult;
	}
}
