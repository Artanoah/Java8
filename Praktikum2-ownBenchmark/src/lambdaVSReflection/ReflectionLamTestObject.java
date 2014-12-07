package lambdaVSReflection;

import io_manager.InputDataReader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import benchmark.Constants;

public class ReflectionLamTestObject {
	private List<String> list = new ArrayList<>();
	private Object o;
	private Method f;
	
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
