package streamsVsForEach;

import org.openjdk.jmh.annotations.Benchmark;

import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import benchmark.Constants;


public class ForEachTestObject {

        @Benchmark
	public void forEachBenchmark() throws IOException {
                int size = 100;
                List<String> list = InputDataReader.readFileLines(Constants.sgbWords, size);

		for(String element : list) {
			element.toUpperCase();
		}
	}
}
