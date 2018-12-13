package java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java8.ExecuteAround.bufferedReaderProcessor;

public class ExecuteAroung {

	public static String processFileLimited() throws IOException{
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("filepath.txt"))){
			return bufferedReader.readLine();
		
		}
	}
	
	public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) 
	throws IOException{
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("path.txt"))){
			return bufferedReaderProcessor.process(bufferedReader);
		}
	}



	public interface BufferedReaderProcessor{
		public String process(BufferedReader bufferedReader) throws IOException;
	}
	
	public static void main(String... args) {
		String oneLine = processFile((BufferedReader br) -> br.readLine());
		String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
	}
}
