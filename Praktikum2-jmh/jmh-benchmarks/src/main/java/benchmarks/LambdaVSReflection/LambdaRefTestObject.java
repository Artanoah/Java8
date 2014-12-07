package benchmarks.LambdaVSReflection;

import general.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

public class LambdaRefTestObject {

	private Function<String, String> f = (s -> s.toUpperCase());
	
	@Param({"10", "100", "200", "400", "800"})
	public int size;
		
	@Benchmark
	public void forEachBenchmark() throws IOException {
		List<String> list = InputDataReader.readFileLines(Constants.sgbWords, size);
		
		for(int i = 0; i < list.size(); i++) {
			f.apply(list.get(i));
		}
	}
}
