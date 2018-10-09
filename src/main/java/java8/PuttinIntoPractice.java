package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PuttinIntoPractice {
	public static void main(String...args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactionList = Arrays.asList(
        		new Transaction(brian, 2011, 300), 
        	    new Transaction(raoul, 2012, 1000),
        	    new Transaction(raoul, 2011, 400),
        	    new Transaction(mario, 2012, 710),	
        	    new Transaction(mario, 2012, 700),
        	    new Transaction(alan, 2012, 950)
        );
        // Query 1: Find all transactions from year 2011 
     	//and sort them by value (small to high).
           
        List<Transaction> list = transactionList.stream()
        								.filter(t -> t.getYear() >= 2011)
        								.sorted(comparing(Transaction::getValue))
        								.collect(toList());
        
        
        // Query 2: What are all the unique cities where the traders work?
        
        transactionList.stream()
        		.map(t -> t.getTrader().getCity())
        		.distinct()
        		.collect(toList());
        
        // Query 3: Find all traders from Cambridge and sort them by name.
        transactionList.stream()	
        		.map(Transaction::getTrader)
        		.filter(t -> t.getCity().equals("Cambridge"))
        		.sorted(comparing(Trader::getName))
        		.collect(toList());
        
        // Query 4: Return a string of all traders’ names sorted alphabetically.
        String reduce = transactionList.stream()
        		.map(t -> t.getTrader().getName())
        		.distinct()
        		.sorted()
        		.reduce("", (a, b) -> a+b);
        System.out.println(reduce);
        
        // Query 5: Are there any trader based in Milan?
        
        Optional opt = transactionList.stream()
        		.filter(t -> t.getTrader().getCity().equals("mario"))
        		.findAny();
        System.out.println(opt.isPresent());
        // Query 6: Update all transactions so that the traders
        //from Milan are set to Cambridge.
        transactionList.stream()
        		.map(Transaction::getTrader)
        		.filter(t -> t.getCity().equals("Milan"))
        		.forEach(t -> t.setCity(""));
        
        // Query 7: What's the highest value in all the transactions?
        transactionList.stream()
        		.max(comparing(Transaction::getValue));
         
	}
}
