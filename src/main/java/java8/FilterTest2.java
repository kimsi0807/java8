package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import java8.FilterTest.Apple;



public class FilterTest {

	public static void main(String ...args) {
		List<Apple> listApple = Arrays.asList(new Apple(80, "green"), 
											new Apple(155, "green"), 
											new Apple(120, "red"));
	
	List<Apple> greenApples = filterApplesByColor(listApple, "green");
//??	List<Apple> greenApples2 = listApple.stream().filter(a ->  "green".equals(a.getColor()));
	
	List<Apple> greenApple3 = filterApplePredicate(listApple, new appleColorPredicate());
	List<Apple> heavyApple4 = filterApplePredicate(listApple, new appleWeightPredicate());
	List<Apple> greenAndHeavyApple = filterApplePredicate(listApple, a ->  "green".equals(a.getColor()) && a.getWeight() >50);
	
	}
	
	public static List<Apple> filterApplesByColor(List<Apple> listApple,
			String color){
		List<Apple> resultList = new ArrayList<>();
		for(Apple apple : listApple) {
			if(color.equals(apple.getColor())) {
				resultList.add(apple);
			}
		}
		return resultList;
	}
	public static List<Apple> filterApplePredicate(List<Apple> listApple,
			applePredicate predicate){
		List<Apple> resultList = new ArrayList<>();
		for(Apple apple : listApple) {
			if(predicate.test(apple)) {
				resultList.add(apple);
			}
		}
		return resultList;
	}
	interface applePredicate {
		public boolean test(Apple a);
	}
	static class appleColorPredicate implements applePredicate{
		public boolean test(Apple a) {
			return "green".equals(a.getColor());
		}
	}
	static class appleWeightPredicate implements applePredicate{
		@Override
		public boolean test(Apple a) {
			// TODO Auto-generated method stub
			return a.getWeight() > 50;
		}
	}
	
}
