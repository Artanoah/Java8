package benchmarks.parallelStreamsVSSerialStreams;

import general.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

public class SerialStreamTestObject {

	@Param({ "100", "1000", "10000", "100000" })
	public int size;
		
	@Benchmark
	public void forEachBenchmark() throws IOException {
		List<String> list = InputDataReader.readFileLines(Constants.sgbWords, size);

		list.stream().forEach(e -> e.toUpperCase());
	}
}
