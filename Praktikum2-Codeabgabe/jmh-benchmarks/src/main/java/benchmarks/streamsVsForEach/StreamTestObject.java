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

	@Param({ "100", "1000", "10000", "100000", "1000000" })
	public int size;
	
	@Benchmark
	public void streamBenchmark() throws IOException {	
		List<String> list = InputDataReader.readFileLines(Constants.sgbWords, size);
		list.stream().forEach(e -> e.toUpperCase());
	}

}
