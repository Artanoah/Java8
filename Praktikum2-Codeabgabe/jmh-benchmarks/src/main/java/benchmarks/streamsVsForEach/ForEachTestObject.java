package benchmarks.streamsVsForEach;

import general.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.Level;

/**
 * @author Hendrik Albers, Steffen Giersch, Maximilian Heinrich, Hector Smith, Jeremias Twele
 */

@State(Scope.Benchmark)
public class ForEachTestObject {

	/**
	 * size is the number of lines to be read
	 * The jmh benchmark will run a test for each value
	 */
    @Param({ "100", "1000", "10000", "100000" })
	public int size;
	
	List<String> list;
	
	@Setup(Level.Iteration)
	public void initializeList() throws IOException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
		
	}

	/**
	 * Iterates through the list using forEach and call toUpperCase()
	 * on each element
	 */
	@Benchmark
	public List<String> forEachBenchmark() {
        List<String> result = new ArrayList<>(size);		

		for (String element : list) {
			result.add(element.toUpperCase());
		}
		
		return result;
	}
}
