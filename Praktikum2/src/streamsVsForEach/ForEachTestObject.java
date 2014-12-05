package streamsVsForEach;

import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import benchmark.Constants;


public class ForEachTestObject {
	private List<String> list = new ArrayList<String>();
	
	public ForEachTestObject(int size) throws IOException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
	}
	
	public void forEachBenchmark() {
		for(String element : list) {
			element.toUpperCase();
		}
	}
}
