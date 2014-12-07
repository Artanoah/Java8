package benchmarks.LambdaVSReflection;

import general.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class ReflectionLamTestObject {
	
	private Object o;
	private Method f;

	@Param({ "100", "1000", "10000", "100000", "1000000" })
	public int size;
		
	@Benchmark
	public void forEachBenchmark() throws IOException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException {
		
		//	Initialize
		List<String> list = InputDataReader.readFileLines(Constants.sgbWords, size);
		
		o = Dummy.class.newInstance();
		
		Class<?>[] inputTypes = {
				String.class
		};
		
		f = Dummy.class.getDeclaredMethod("stringConsumer", inputTypes);
		
		//	Test
		for(int i = 0; i < list.size(); i++) {
			f.invoke(o, list.get(i));
		}
	}
}
