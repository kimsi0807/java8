package java8_2;

import java.util.Arrays;
import java.util.List;

public class Game {
	
	public static void  main(String...args) {
		List<Resizable> resizableShapes = Arrays.asList(new Square(),
				new Eclipse());
		
		Utils.paint(resizableShapes);
	}

}
