package benchmarks.LambdaVSAnonymous;

import general.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

public class AnonymousClassTestObject {

	@Param({"10", "100", "200", "400", "800"})
	public int size;
	
	@Benchmark
	public void forEachBenchmark() throws IOException {
		List<String> list = InputDataReader.readFileLines(Constants.sgbWords, size);

		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				s.toUpperCase();
			}
		});
	}
}