package benchmarks.LambdaVSReflection;

import general.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * @author Hendrik Albers, Steffen Giersch, Maximilian Heinrich, Hector Smith, Jeremias Twele
 */

@State(Scope.Benchmark)
public class LambdaRefTestObject {

	private Function<String, String> f = (s -> s.toUpperCase());

	/**
	 * size is the number of lines to be read
	 * The jmh benchmark will run a test for each value
	 */
    @Param({ "100", "1000", "10000", "100000", "1000000", "10000000" })
	public int size;
		
	/**
	 * Iterates through the list using a for-loop and calls toUpperCase()
	 * on each element using
	 */
	@Benchmark
	public void lambdaBenchmark() throws IOException {
		List<String> list = InputDataReader.readFileLines(Constants.sgbWords, size);
		
		for(int i = 0; i < list.size(); i++) {
			f.apply(list.get(i));
		}
	}
}
