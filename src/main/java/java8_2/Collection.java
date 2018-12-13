package java8_2;

import java.util.Arrays;
import java.util.List;

public class Collection {

	public static void main(String... args) {
		List<String> names = Arrays.asList("java","in","action");
		names.stream()
			.forEach(System.out::println);
	}
}
