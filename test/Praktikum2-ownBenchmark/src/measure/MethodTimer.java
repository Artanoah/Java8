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
 * @author Steffen Giersch, Max Zender, Hendrik Albers, Jeremias Twele, Hector Smith, added measurement of memory usage.
 */

public class MethodTimer {
	/**
	 * The amount of test data to create.
	 */
	private final int size;

	/**
	 * The method to test.
	 */
	private final Method method;

	/**
	 * The instance of the test object.
	 */
	private Object instance;

	/**
	 * The total execution time.
	 */
	private long totalTime;

	/**
	 * The number of iterations to perform.
	 */
	private int iterations;

	/**
	 * The reference overhead timer.
	 */
	private MethodTimer overheadTimer;

	/**
	 * The memory usage in each iteration.
	 */
	public List<Long> memoryUsage;

	/**
	 * The constructor.
	 *
	 * @param size The amount of test data to create.
	 * @param method The method to test.
	 * @throws Exception In case the instantiation of the test object fails.
	 */
	MethodTimer(int size, Method method) throws Exception{
		this.size = size;
		this.method = method;
		this.instance = createInstance();
		this.memoryUsage = new ArrayList<Long>();
	}

	/**
	 * Private constructor for the reference overhead timer.
	 *
	 * @param iterations The number of iterations to perform.
	 * @throws Exception In case the instantiation of the Overhead class fails.
	 */
	private MethodTimer(int iterations) throws Exception {
		this(0, MethodTimer.Overhead.class.getMethod("nothing", new Class[0]));
		this.iterations = iterations;
		this.memoryUsage = new ArrayList<>(this.iterations);
	}

	/**
	 * The total execution time.
	 *
	 * @return The total execution time.
	 * @throws Exception In case the invocation of the test method fails.
	 */
	double getMethodTime() throws Exception {
		long overhead = overheadTimer.computeTotalTime();
		return (double)(totalTime - overhead) / (double)iterations;
	}

	/**
	 * Returns the average memory usage without the calculated overhead.
	 *
	 * @return The average memory usage.
	 */
	double getMethodMemoryUsage() {
		return this.getAverageMemoryUsage() - overheadTimer.getAverageMemoryUsage();
	}

	/**
	 * Returns the uncorrected average memory usage.
	 *
	 * @return The uncorrected average memory usage.
	 */
	double getAverageMemoryUsage() {
		Long totalMemoryUsage = memoryUsage.stream().reduce(0l, (a, b) -> a+b);
		return totalMemoryUsage / this.iterations;
	}

	/**
	 * Run the benchmark.
	 *
	 * @throws Exception In case the instantiation of the test object fails.
	 */
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

	/**
	 * Computes the total execution time.
	 *
	 * @return The execution time.
	 * @throws Exception In case the invocation of the test method fails.
	 */
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

	/**
	 * Creates an instance of the test object.
	 *
	 * @return The test object.
	 * @throws Exception In case the instantiation fails.
	 */
	private Object createInstance() throws Exception{
		Constructor<?> constructor = method.getDeclaringClass().getConstructor(new Class[]{int.class});
		return constructor.newInstance(new Object[]{size});
	}

	/**
	 * Returns the current memory usage.
	 *
	 * @return The current memory usage.
	 */
	private long getCurrentMemoryUsage() {
		return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
	}

	/**
	 * The reference overhead class.
	 */
	public static class Overhead{
	    public Overhead(int size){

	    }
		public void nothing(){

		}
	}
}
