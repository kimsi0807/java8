package java8;

import java.util.Optional;
import java.util.Properties;


import static java.util.Optional.*;

public class RoadPositiveIntParam {

	public void testMap() {
		Properties properties = new Properties();
		properties.setProperty("a", "5");
		properties.setProperty("b", "true");
		
		///
		
	}
	
	public static int readDurationImperative(Properties properties, String name) {
		String value = properties.getProperty(name);
		if(value != null) {
			try {
				int i = Integer.parseInt(value);
				if(i > 0) {
					return i;
				}
			}catch(NumberFormatException e) {}
		}
		return 0;
	}
	
	public static int readDurationWithOptional(Properties properties, String name) {
		return ofNullable(properties.getProperty(name))
				.flatMap(RoadPositiveIntParam::StringToInteger)
				.filter(i -> i > 0)
				.orElse(0);
	}
	public static Optional<Integer> StringToInteger(String s){
		try {
			return of(Integer.parseInt(s));
		}catch(NumberFormatException e) {
			return empty();
		}
	}
}
