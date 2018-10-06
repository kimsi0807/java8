package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Lambdas {
	public static void main(String ... args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("runnable interface..");
			}
		};
		runnable.run();
		
		Runnable runnable2 = () -> System.out.println("runnable expression using lambda");
		runnable2.run();
		
		List<Apple> appleList  = Arrays.asList(new Apple(80, "green"),new Apple(155, "green"), new Apple(120, "red"));
		
		List<Apple> listApple = filter(appleList, a -> "green".equals(a.getColor()));
		Comparator<Apple> appleComparator = (Apple a, Apple a2) -> a.getWeight().compareTo(a2.getWeight());
		appleList.sort(appleComparator);
		
	}
	interface applePredicate{
		public boolean test(Apple a);
	}
	public static List<Apple> filter(List<Apple> appleList,
			applePredicate applepredicate){
		List<Apple> resultList = new ArrayList<>();
		for (Apple apple : appleList) {
			if(applepredicate.test(apple)) {
				resultList.add(apple);
			}
		}
		return resultList;
	}
	@Getter
	@Setter
	@AllArgsConstructor
	public static class Apple {
		Integer weight;
		String color;
	}
}
