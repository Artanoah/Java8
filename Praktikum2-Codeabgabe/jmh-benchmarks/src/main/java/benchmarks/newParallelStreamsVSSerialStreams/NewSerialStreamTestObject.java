package benchmarks.newParallelStreamsVSSerialStreams;

import general.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import java.util.stream.IntStream;

/**
 * @author Hendrik Albers, Steffen Giersch, Maximilian Heinrich, Hector Smith, Jeremias Twele
 */

@State(Scope.Benchmark)
public class NewSerialStreamTestObject {

    @Param({ "100", "1000", "10000", "100000", "1000000" })
	public int size;
	
	@Benchmark
	public long serialStreamBenchmark() {
		return IntStream.range(1, size).filter(this::isPrime).count();
	}
	
	private boolean isPrime(int n) {
		return n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
	}
}
