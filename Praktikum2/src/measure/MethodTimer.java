package measure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


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
	private long overhead;

	MethodTimer(int size, Method method) throws Exception{
		this.size = size;
		this.method = method;
		this.instance = createInstance();
	}
	private static MethodTimer overheadTimer(int iterations) throws Exception{
		return new MethodTimer(iterations);
	}
	private MethodTimer(int iterations)throws Exception{
		this(0,MethodTimer.Overhead.class.getMethod("nothing", new Class[0]));
		this.iterations = iterations;
	}
	double getMethodTime(){
		return (double)(totalTime - overhead)/(double)iterations;
	}
	void run()throws Exception{
		iterations = 1;
		while(true){
			totalTime = computeTotalTime();
			if(totalTime > MethodsTimer.ONE_SECOND)
				break;
			iterations*=2;
		}
		overhead = overheadTimer(iterations).computeTotalTime();
		
	}
	//Check for Correctness, is missing in Implemention Patterns
	private long computeTotalTime() throws Exception {
		System.gc();
		Thread.sleep(1000);
	 	long start = System.nanoTime();
	 	for (int i = 0; i < iterations; i++)
	 		method.invoke(instance, new Object[0]);
	 	return System.nanoTime() - start;
	}
	private Object createInstance() throws Exception{
		Constructor<?> constructor = method.getDeclaringClass().getConstructor(new Class[]{int.class});
		return constructor.newInstance(new Object[]{size});
	}
	public static class Overhead{
	    public Overhead(int size){
	        
	    }
		public void nothing(){
			
		}
	}
}