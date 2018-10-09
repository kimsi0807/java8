package java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStream {
	public static void main(String...args) throws IOException {
		//Stream.of
		Stream<String> streamString = Stream.of("one","two","three");
		streamString.map(String::toUpperCase)
			.forEach(System.out::println);
		
		//Stream.empty
		Stream<String> emptyStream = Stream.empty();
		
		//Arrays.stream
		int[] numbers = {2,3,4,5,6,7};
		System.out.println(Arrays.stream(numbers).sum());
		
		//Stream.iterate
		Stream.iterate(0, n -> n+1)
			.limit(3)
			.forEach(System.out::println);
		
		Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1],t[0]+t[1]})
			.limit(10)
			.forEach(t -> System.out.println(t[0]+","+t[1]));
		//
		Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1],t[0]+t[1]})
			.limit(10)
			.map(t -> t[0])
			.forEach(System.out::println);
		
		//Stream.generate
		Stream.generate(Math::random)
			.limit(3)
			.forEach(System.out::println);
		
		Stream.generate(() -> 1)
			.limit(3)
			.forEach(System.out::println);
		
		IntStream.generate(new IntSupplier() {
			
			@Override
			public int getAsInt() {
				// TODO Auto-generated method stub
				return 3;
			}
		}).limit(3)
		.forEach(System.out::println);
		
		IntSupplier intSupplier = new IntSupplier() {
			private int pre = 0;
			private int current = 1;
			@Override
			public int getAsInt() {
				// TODO Auto-generated method stub
				int next = this.pre + this.current;
				pre = this.current;
				this.current = next;
				return this.pre;
			}
		};
		
		IntStream.generate(intSupplier)
			.limit(10)
			.forEach(System.out::println);
		
		long uniqueWords = Files.lines(Paths.get("path.txt"),Charset.defaultCharset())
				.flatMap(line -> Arrays.stream(line.split(" ")))
				.distinct()
				.count();
		
		System.out.println(uniqueWords);
	}

}
