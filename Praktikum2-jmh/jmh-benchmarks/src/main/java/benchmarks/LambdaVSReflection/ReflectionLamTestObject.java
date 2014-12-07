package benchmarks.LambdaVSReflection;

import general.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

public class ReflectionLamTestObject {
	
	private Object o;
	private Method f;
	
	@Param({"10", "100", "200", "400", "800"})
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
	
	
	
	
	private List<String> list = new ArrayList<>();
	
	public ReflectionLamTestObject(int size) throws IOException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
		
		o = Dummy.class.newInstance();
		
		Class<?>[] inputTypes = {
				String.class
		};
		
		f = Dummy.class.getDeclaredMethod("stringConsumer", inputTypes);
	}
	
	public void reflectionBenchmark() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for(int i = 0; i < list.size(); i++) {
			f.invoke(o, list.get(i));
		}
	}
}
