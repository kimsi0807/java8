package java8;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;



public class FilteringApples {
	public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }
	public static List<Apple> filterHeavyApples(List<Apple> inventory, Predicate<Apple> p){
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	public static void main(String... args) {
		List<Apple> list = Arrays.asList(new Apple(80, "green")
										,new Apple(20, "orange")
										);
		List<Apple> heavyApple = filterHeavyApples(list, (Apple a) -> a.getWeight() > 50);
		List<Apple> heavyApple2 = filterHeavyApples(list, (Apple a) -> a.getWeight() >40 &&
				a.getWeight() <100);
		
		Runnable r = () -> System.out.println("gg");
		
		Comparator<Apple> c = (Apple a, Apple b) -> a.getWeight().compareTo(b.getWeight());
		list.sort(c);
		
		list.sort((Apple a, Apple b) -> a.getWeight().compareTo(b.getWeight()));
		
		list.sort(comparing(Apple::getWeight));
	}
}
