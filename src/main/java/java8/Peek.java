package java8;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public class Peek {

	public static void main(String...args) {
		List<Integer> result = Stream.of(2,3,4,5)
				.peek(x -> System.out.println("after strem")).map(x -> x+11)
				.peek(x -> System.out.println()).filter(x -> x%2 ==0)
				.peek(x -> System.out.println()).limit(4)
				.peek(x -> System.out.println()).collect(toList());
	}
}
