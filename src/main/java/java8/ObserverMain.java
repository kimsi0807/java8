package java8;

import java.util.ArrayList;
import java.util.List;

public class ObserverMain {

	interface Observer{
		void inform(String tweet);
	}
	
	interface Subject{
		void registerObserver(Observer o);
		void notifyObservers(String tweet);
		
	}
	
	static private class Nytimes implements Observer{
		@Override
		public void inform(String tweet) {
			// TODO Auto-generated method stub
			if(tweet != null && tweet.contains("money")) {
				System.out.println("breaking new..in ny"+tweet);
			}
		}
	}
	static private class Guardina implements Observer{
		@Override
		public void inform(String tweet) {
			// TODO Auto-generated method stub
			if(tweet != null && tweet.contains("queen")) {
				System.out.println();
			}
		}
	}
	static private class Feed implements Subject{
		private final List<Observer> observers = new ArrayList<>();
		@Override
		public void registerObserver(Observer o) {
			// TODO Auto-generated method stub
			this.observers.add(o);
		}
		@Override
		public void notifyObservers(String tweet) {
			// TODO Auto-generated method stub
			observers.forEach(o -> o.inform(tweet));
		}
	}
	public static void main(String...args) {
		Feed feed = new Feed();
		feed.registerObserver(new Nytimes());
		feed.registerObserver(new Guardina());
		feed.notifyObservers("");
		
		/////
		Feed feedLambda = new Feed();
		feedLambda.registerObserver((String tweet) -> {
		if(tweet != null && tweet.contains("money")) System.out.println("");
		});
		
		feedLambda.notifyObservers("money..");
	}
	
	
	
	
	
	
	
	
}
