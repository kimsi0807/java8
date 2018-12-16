package java8_2;

import java.util.Arrays;
import java.util.List;
import java8_2.Transaction;
import java8_2.Trader;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * <pre>
 * java8_2
 * PuttingIntoPrac.java
 * </pre>
 *
 * @author pretty snake
 * @Date : 2018. 12. 16.
 * @version : 0.1
 */
public class PuttingIntoPrac {

	public PuttingIntoPrac() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );
		
		//1
		transactions.stream()
					.filter( t -> t.getYear() == 2011)
					.sorted(comparing(java8_2.Transaction::getValue))
					.collect(toList());
		//2
		transactions.stream()
					.map(t -> t.getTrader().getCity())
					.distinct()
					.collect(toList());
		
		//3
		transactions.stream()
					.map(java8_2.Transaction::getTrader)
					.filter(t -> t.getCity() =="")
					.distinct()
					.sorted(comparing(java8_2.Trader::getName))
					.collect(toList());
		
		//4
		transactions.stream()
					.map(t -> t.getTrader().getName())
					.distinct()
					.sorted()
					.reduce("", (a, b) -> a+b);
		//5
		transactions.stream()
					.filter(t-> t.getTrader().getCity().equals(""))
					.findAny();
		
		//6
		transactions.stream()
					.map(Transaction::getTrader)
					.filter(t -> t.getCity().equals(""))
					.forEach(t -> t.setCity(""));
		//7
		transactions.stream()
					.mapToInt(t-> t.getValue())
					.max();
	}
}
