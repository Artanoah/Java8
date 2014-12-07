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
	
	/**
	 * Constructor
	 * The Constructor initializes the List and fills it
	 * with the given number of lines from the Constants.sgbWords
	 * 
	 * @param size The number of lines to be read
	 * @throws IOException
	 */
	public ReflectionLamTestObject(int size) throws IOException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
		
		o = Dummy.class.newInstance();
		
		Class<?>[] inputTypes = {
				String.class
		};
		
		f = Dummy.class.getDeclaredMethod("stringConsumer", inputTypes);
	}
	
	/**
	 * Iterates through the list using a for-loop and calls invoke each time.
	 */
	public void reflectionBenchmark() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for(int i = 0; i < list.size(); i++) {
			f.invoke(o, list.get(i));
		}
	}
}
