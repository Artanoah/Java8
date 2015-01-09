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

/**
 * @author Hendrik Albers, Steffen Giersch, Maximilian Heinrich, Hector Smith, Jeremias Twele
 */

@State(Scope.Benchmark)
public class AnonymousClassTestObject {

	/**
	 * size is the number of lines to be read
	 * The jmh benchmark will run a test for each value
	 */
	@Param({ "100", "1000", "10000", "100000", "1000000" })
	public int size;
	
	/**
	 * Iterates through the list using forEach and call toUpperCase()
	 * on each element within an anonymousClass
	 */
	@Benchmark
	public void anonymousClassBenchmark() throws IOException {
		List<String> list = InputDataReader.readFileLines(Constants.sgbWords, size);

		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				s.toUpperCase();
			}
		});
	}
}