package benchmarks.LambdaVSAnonymous;

import general.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class AnonymousClassTestObject {

	@Param({ "100", "1000", "10000", "100000", "1000000" })
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