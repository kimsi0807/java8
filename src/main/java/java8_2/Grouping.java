package java8_2;

import java8_2.Dish;
import sun.util.resources.cldr.or.CalendarData_or_IN;

import static java8_2.Dish.menu;

import java.util.Optional;

import static java.util.stream.Collectors.*;
/**
 * <pre>
 * java8_2
 * Grouping.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */
public class Grouping {

	public Grouping() {
		// TODO Auto-generated constructor stub
	}
	
	enum Caloriclevel {
		DIET,
		NORMAL,
		FAT
	};
	
	public static void main(String[] args) {
		menu.stream().collect(groupingBy(Dish::getType));
		
		menu.stream().collect(
				groupingBy( d -> {
					if(d.getCalories() < 400 ) return Caloriclevel.DIET;
					else if( d.getCalories() < 700) return Caloriclevel.NORMAL;
					else return Caloriclevel.FAT;
				}));
		
		menu.stream().collect(
				groupingBy(Dish::getType,
						groupingBy(d -> {
							if(d.getCalories() <400) return Caloriclevel.FAT;
							else return Caloriclevel.NORMAL;
						})));
		
		menu.stream().collect(groupingBy(Dish::getType, counting()));
		
		menu.stream().collect(groupingBy(Dish::getType,
				reducing((a,b) -> a.getCalories() > b.getCalories() ? a:b)
				));
		
		menu.stream().collect(
				groupingBy(Dish::getType, 
				collectingAndThen(reducing((a, b) ->  a.getCalories() > b.getCalories() ? a:b),
				Optional::get
				)));
		
		menu.stream().collect(groupingBy(Dish::getType,
				summingInt(Dish::getCalories)
				));
		
		menu.stream().collect(groupingBy(Dish::getType,
				mapping(d -> {
					if(d.getCalories() < 400 ) return Caloriclevel.DIET;
					else if( d.getCalories() < 700) return Caloriclevel.NORMAL;
					else return Caloriclevel.FAT;
					
				}, toSet())
				));
		
	}
	
	

}
