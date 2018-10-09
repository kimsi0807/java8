package java8;

import static java8.Dish.menu;

import java.util.Optional;


public class Finding {

	public static void main(String...args) {
		if(isVesetarianFriendlyMenu()) {
			System.out.println("vegetarian friendly menu..");
		}
	
		System.out.println(isHealthyMenu());
		System.out.println(idHealthyMenu());
		
		Optional<Dish> dish = findVegetarianDish();
		dish.ifPresent(d -> System.out.print(d.getName()));
	}
	
	//Stream.anyMath()
	public static boolean isVesetarianFriendlyMenu() {
		return menu.stream().anyMatch(Dish::isVegetarian);
	}
	
	//Steam.allMatch()
	public static boolean isHealthyMenu() {
		return menu.stream().allMatch(a -> a.getCalories() <1000);
	}
	
	//Stream.noneMatch()
	public static boolean idHealthyMenu() {
		return menu.stream().noneMatch(a -> a.getCalories() > 1000);
	}

	//Stream.findAny()
	public static Optional<Dish> findVegetarianDish(){
		return menu.stream()
					.filter(Dish::isVegetarian)
					.findAny();
	}
}
