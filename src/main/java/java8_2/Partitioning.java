package java8_2;

import static java8_2.Dish.menu;

import java.util.Optional;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

/**
 * <pre>
 * java8_2
 * Partitioning.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */
public class Partitioning {

	public Partitioning() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		menu.stream().collect(partitioningBy(Dish::isVegetarian));
		menu.stream().collect(partitioningBy(Dish::isVegetarian,
				groupingBy(Dish::getType)
				));
		
		menu.stream().collect(
				partitioningBy(Dish::isVegetarian,
					collectingAndThen(
						maxBy(comparing(Dish::getCalories)), 
						Optional::get)
				));
		
	}

}
