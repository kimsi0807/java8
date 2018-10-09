package java8;

import java.util.Arrays;
import java.util.List;

public class StreamVsCollection {

	public static void main(String...args) {
		List<String> listNames = Arrays.asList("java8","lambdas","in");
		java.util.stream.Stream<String> stream = listNames.stream();
		stream.forEach(System.out::println);
	}
}
