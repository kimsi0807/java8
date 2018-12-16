package java8_2;

import static java.util.stream.Collectors.reducing;

import java.util.stream.LongStream;
import java.util.stream.Stream;
/**
 * <pre>
 * java8_2
 * ParallelStream.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */
public class ParallelStream {

	public ParallelStream() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Stream.iterate(1L, n -> n+1)
				.limit(5)
				.collect(reducing((a,b)->a+b));
		
		Stream.iterate(1, n -> n+1)
				.limit(5)
				.parallel()
				.reduce(Integer::sum)
				.get();
		
		LongStream.rangeClosed(0, 10)
					.reduce(Long::sum)
					.getAsLong();
		
		LongStream.range(0, 10)
					.parallel()
					.reduce(Long::sum)
					.getAsLong();
	}
}
