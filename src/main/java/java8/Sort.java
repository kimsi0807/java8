package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import static java.util.Comparator.comparing;

public class Sort {
	public static void main(String ... args) {
		
		List<Apple> appleList = new ArrayList<>();
		appleList.addAll(Arrays.asList(new Apple("green", 80)));
		
		//1
		appleList.sort(new appleComparator());
		
		appleList.set(1, new Apple("blue", 150));
		//2
		appleList.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				// TODO Auto-generated method stub
				return o1.getWeight().compareTo(o2.getWeight());
			}
		});
		//3
		appleList.sort((a,b) -> a.getWeight().compareTo(b.getWeight()));
				
		//4 comparing...
		appleList.sort(comparing(Apple::getWeight));
	}
	
	static class appleComparator implements Comparator<Apple>{
		@Override
		public int compare(Apple o1, Apple o2) {
			// TODO Auto-generated method stub
			return o1.getWeight().compareTo(o2.getWeight());
		}
	}
	
	@AllArgsConstructor
	@Getter
	@Setter
	@ToString
	public static class Apple{
		private String color;
		private Integer weight;
	}
}
