package parallelStreamsVSSerialStreams;

import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import benchmark.Constants;

public class SerialStreamTestObject {
	private List<String> list = new ArrayList<>();
	
	public SerialStreamTestObject(int size) throws IOException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
	}
	
	public void serialStreamBenchmark() {
		list.stream().forEach(e -> e.toUpperCase());
	}
}
