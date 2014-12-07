package parallelStreamsVSSerialStreams;

import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import benchmark.Constants;

public class ParallelStreamTestObject {
	private List<String> list = new ArrayList<>();
	
	/**
	 * Constructor
	 * The Constructor initializes the list and fills it
	 * with the given number of lines from the Constants.sgbWords
	 * 
	 * @param size The number of lines to be read
	 * @throws IOException
	 */
	public ParallelStreamTestObject(int size) throws IOException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
	}
	
	/**
	 * Iterates through the list using forEach and call toUpperCase()
	 * on each element using parallelStream
	 */
	public void parallelStreamBenchmark() {
		list.parallelStream().forEach(e -> e.toUpperCase());
	}
}
