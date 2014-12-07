package parallelStreamsVSSerialStreams;

import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import benchmark.Constants;

public class ParallelStreamTestObject {
	private List<String> list = new ArrayList<>();
	
	public ParallelStreamTestObject(int size) throws IOException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
	}
	
	public void parallelStreamBenchmark() {
		list.parallelStream().forEach(e -> e.toUpperCase());
	}
}
