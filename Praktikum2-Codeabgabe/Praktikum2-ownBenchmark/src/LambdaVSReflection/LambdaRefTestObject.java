package LambdaVSReflection;

import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import benchmark.Constants;

public class LambdaRefTestObject {
	private List<String> list = new ArrayList<>();
	private Function<String, String> f = (s -> s.toUpperCase());
	
	
	/**
	 * Constructor
	 * The Constructor initializes the List and fills it
	 * with the given number of lines from the Constants.sgbWords
	 * 
	 * @param size The number of lines to be read
	 * @throws IOException
	 */
	public LambdaRefTestObject(int size) throws IOException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
	}
	
	/**
	 * Iterates through the list using a for-loop and calls toUpperCase()
	 * on each element using
	 */
	public void lambdaBenchmark() {
		for(int i = 0; i < list.size(); i++) {
			f.apply(list.get(i));
		}
	}
}
