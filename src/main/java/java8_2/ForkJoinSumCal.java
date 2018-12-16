package java8_2;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCal  extends RecursiveTask<Long>{

	public static final long THREDSHOLD = 10_000;
	
	private final long[] numbers;
	private final int start;
	private final int end;
	
	public ForkJoinSumCal(long[] numbers) {
		// TODO Auto-generated constructor stub
		this(numbers,0,numbers.length);
	}
	private ForkJoinSumCal(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

	@Override
	protected Long compute() {
		// TODO Auto-generated method stub
		int length = end - start;
		if(length <= THREDSHOLD) {
			return computeSequentially();
		}
		ForkJoinSumCal left = new ForkJoinSumCal(numbers, start,  start + length/2);
		ForkJoinSumCal right = new ForkJoinSumCal(numbers, start + length/2, end);
		Long rightResult = right.compute();
		Long leftResult = left.join();
		return leftResult + rightResult;
	}
	private long computeSequentially() {
		long sum = 0;
		for(int i = start; i < end ; i++) {
			sum += numbers[i];
		}
		return sum;
	}
	public static long forJoinSum(long n) {
		long[] numbers = LongStream.rangeClosed(1,n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCal(numbers);
		return FORK_JOIN_POOL.invoke(task);
	}
	

}
