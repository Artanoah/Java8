package benchmarks.streamsVsForEach;

import general.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;


@State(Scope.Benchmark)
public class StreamTestObject {

	/**
	 * size is the number of lines to be read
	 * The jmh benchmark will run a test for each value
	 */
	@Param({ "100", "1000", "10000", "100000", "1000000" })
	public int size;

	/**
	 * Iterates through the list using forEach and call toUpperCase()
	 * on each element using a stream
	 */
	@Benchmark
	public void streamBenchmark() throws IOException {	
		List<String> list = InputDataReader.readFileLines(Constants.sgbWords, size);
		list.stream().forEach(e -> e.toUpperCase());
	}

}
