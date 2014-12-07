package lambdaVSAnonymous;

import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import benchmark.Constants;

public class AnonymousClassTestObject {

	private List<String> list = new ArrayList<>();

	
	/**
	 * Constructor
	 * The Constructor initializes the list and fills it
	 * with the given number of lines from the Constants.sgbWords
	 * 
	 * @param size The number of lines to be read
	 * @throws IOException
	 */
	public AnonymousClassTestObject(int size) throws IOException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
	}

	/**
	 * Iterates through the list using forEach and call toUpperCase()
	 * on each element within an anonymousClass
	 */
	public void anonymousClassBenchmark() {
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				s.toUpperCase();
			}
		});
	}
}