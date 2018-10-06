package java8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
	
	public static void main(String ... args) throws FileNotFoundException, IOException{
		String result = processFileLimit();
		System.out.println(result);
		
		String oneList = processFile((BufferedReader b) -> b.readLine());
		String twoList = processFile(p -> p.readLine());
	}
	
	public static String processFileLimit() throws FileNotFoundException, IOException {
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"))){
			return bufferedReader.readLine();
		}
	}
	public static String processFile(bufferedReaderProcessor bufferedReaderprocessor) throws FileNotFoundException, IOException {
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("fileName.txt"))){
			return bufferedReaderprocessor.process(bufferedReader);
		}
	}
	public interface bufferedReaderProcessor{
		public String process(BufferedReader bufferedReader) throws FileNotFoundException, IOException;
	}
}
