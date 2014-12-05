package streamsVsForEach;

import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import benchmark.Constants;

public class StreamTestObject {
	private List<String> list = new ArrayList<>();
	
	public StreamTestObject(int size) throws IOException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
	}
	
	public void streamBenchmark() {
		list.stream().forEach(e -> e.toUpperCase());
	}

}
