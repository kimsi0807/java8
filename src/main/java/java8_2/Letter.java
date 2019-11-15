package java8_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Letter {

    public static String addHeader(String text){
        return "From Raoul, Mario and Alan:" + text;
    }

    public static String addFooter(String text){
        return text + "Kind regards";
    }

    public static String checkSpelling(String text){
        return text.replaceAll("C\\+\\+", "**Censored**");
    }

    public static void main(String[] args) {
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> pipeline = addHeader.andThen(Letter::checkSpelling)
												.andThen(Letter::addFooter);
		
		List<Integer> numbers = Arrays.asList(1,2,3,4);
		numbers.sort(Comparator.naturalOrder());
				
	}
}
