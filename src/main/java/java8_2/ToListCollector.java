package java8_2;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
/**
 * <pre>
 * java8_2
 * ToListCollector.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>>{

	public ToListCollector() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Supplier<List<T>> supplier() {
		// TODO Auto-generated method stub
		return () -> new ArrayList<T>();
	}
	
	@Override
	public BiConsumer<List<T>, T> accumulator() {
		// TODO Auto-generated method stub
		return (list, item) -> list.add(item);
	}
	
	@Override
	public BinaryOperator<List<T>> combiner() {
		// TODO Auto-generated method stub
		return (list1, list2) -> {
			list1.addAll(list2);
			return list1;
		};
	}
	
	@Override
	public Function<List<T>, List<T>> finisher() {
		// TODO Auto-generated method stub
		return i -> i;
	}
	
	@Override
	public Set<Characteristics> characteristics() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
	}
	
	

}
