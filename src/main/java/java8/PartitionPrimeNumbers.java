package java8;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collector.Characteristics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;

public class PartitionPrimeNumbers {

	public static void main(String... args) {
		///
		System.out.println();
	}
	
	public static Map<Boolean, List<Integer>> partitionPrimes(int n){
		return IntStream.range(2, n).boxed().collect(partitioningBy(a -> isPrime(n)));
	}
	
	public static boolean isPrime(int a) {
		return IntStream.rangeClosed(2, a).limit((long)Math.floor(Math.sqrt((double) a))-1)
				.noneMatch(i -> a % i == 0);
	}
	
	public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n){
		return IntStream.rangeClosed(2, n).boxed().collect(new)
	}
	
	
	public static class primeNumbersCollector implements Collector<Integer, 
														Map<Boolean, List<Integer>>, 
														List<Integer>>{
		
		@Override
		public Supplier<Map<Boolean, List<Integer>>> supplier() {
			// TODO Auto-generated method stub
			return () -> new HashMap<Boolean, List<Integer>>(){
				{put(true, new ArrayList<Integer>());
				put(false, new ArrayList<Integer>());
				}
			};
		}
		@Override
		public BinaryOperator<Map<Boolean, List<Integer>>> combiner(){
			return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2)
						->{ map1.get(true).addAll(map2.get(true));
						map1.get(false).addAll(map2.get(false));
						return map1;
						};
		}
		@Override
		public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
			// TODO Auto-generated method stub
			return (Map<Boolean, List<Integer>> map_acc, Integer int_candidate) ->{
				map_acc.get( isPrime( map_acc.get(true), int_candidate)).add(int_candidate);
			};
		}
		@Override
		public Function<Map<Boolean, List<Integer>>, List<Integer>> finisher() {
			// TODO Auto-generated method stub
			return i -> i;
		}
		
		@Override
		public Set<Characteristics> characteristics() {
			// TODO Auto-generated method stub
			return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
		}
		
	}
}	

