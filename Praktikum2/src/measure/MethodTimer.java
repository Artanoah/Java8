package measure;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * An Example from Kent Beck in Implementation Patterns.
 * @author Kent Beck
 * @author Bernd Kahlbrandt, added computeTotalTime().
 */

public class MethodTimer {
	private final int size;
	private final Method method;
	private Object instance;
	private long totalTime;
	private int iterations;
	private MethodTimer overheadTimer;
	public List<Long> memoryUsage;

	MethodTimer(int size, Method method) throws Exception{
		this.size = size;
		this.method = method;
		this.instance = createInstance();
		this.memoryUsage = new ArrayList<Long>();
	}

	private MethodTimer(int iterations) throws Exception {
		this(0, MethodTimer.Overhead.class.getMethod("nothing", new Class[0]));
		this.iterations = iterations;
		this.memoryUsage = new ArrayList<>(this.iterations);
	}

	double getMethodTime() throws Exception {
		long overhead = overheadTimer.computeTotalTime();
		return (double)(totalTime - overhead) / (double)iterations;
	}

	double getMethodMemoryUsage() {
		return this.getAverageMemoryUsage() - overheadTimer.getAverageMemoryUsage();
	}

	private double getAverageMemoryUsage() {
		Long totalMemoryUsage = memoryUsage.stream().reduce(0l, (a, b) -> a+b);
		return totalMemoryUsage / this.iterations;
	}

	void run()throws Exception {
		iterations = 1;
		while(true){
			totalTime = computeTotalTime();
			if(totalTime > MethodsTimer.ONE_SECOND)
				break;
			iterations*=2;
		}
		overheadTimer = new MethodTimer(iterations);
	}

	//Check for Correctness, is missing in Implemention Patterns
	private long computeTotalTime() throws Exception {
		System.gc();
		Thread.sleep(1000);
	 	long start = System.nanoTime();
	 	for (int i = 0; i < iterations; i++) {
			this.memoryUsage.add(getCurrentMemoryUsage());
			method.invoke(instance, new Object[0]);
		}
	 	return System.nanoTime() - start;
	}

	private Object createInstance() throws Exception{
		Constructor<?> constructor = method.getDeclaringClass().getConstructor(new Class[]{int.class});
		return constructor.newInstance(new Object[]{size});
	}

	private long getCurrentMemoryUsage() {
		return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
	}

	public static class Overhead{
	    public Overhead(int size){

	    }
		public void nothing(){

		}
	}
}
