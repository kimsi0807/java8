package java8_2;

import java.util.List;

/**
 * <pre> 
 * Utils.java
 * </pre>
 *
 * @author SEOL
 * @date : 2018. 12. 17.
 * @version : 
 * 
 */public class Utils {
	
	public static void main(String[] args) {
		
	}
	
	public static void paint(List<Resizable> list) {
		list.forEach(l -> l.setAbsoluteSize(20, 20));
	}

}


