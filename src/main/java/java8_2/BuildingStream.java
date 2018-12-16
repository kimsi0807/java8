package java8_2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.PrimitiveIterator.OfInt;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * <pre>
 * java8_2
 * BuildingStream.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */
public class BuildingStream {

	public BuildingStream() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String...args) throws IOException {
		Stream<String> stream = Stream.of("one","two");
		stream.map(String::toUpperCase)
				.forEach(System.out::println);
		
		Stream<String> emptyStream = Stream.empty();
		
		int[] numbers = {2,3,4,5};
		Arrays.stream(numbers).sum();
		
		Stream.iterate(0, n -> n+2)
				.limit(10)
				.forEach(System.out::println);
		
		Stream.generate(Math::random)
				.limit(10)
				.forEach(System.out::println);
		
		Stream.generate(() -> 1)
				.limit(10)
				.forEach(System.out::println);
		
		IntStream.generate(new IntSupplier() {
			
			@Override
			public int getAsInt() {
				// TODO Auto-generated method stub
				return 0;
			}
		}).limit(10)
		.forEach(System.out::println);
		
		Files.lines(Paths.get("/data.txt"),Charset.defaultCharset())
			.flatMap(line -> Arrays.stream(line.split(" ")))
			.distinct()
			.count();
		
	}

}
