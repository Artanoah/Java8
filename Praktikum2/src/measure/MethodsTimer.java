package measure;

import java.lang.reflect.Method;
import java.util.Locale;

/**
 * An Example from Kent Beck in Implementation Patterns.
 * This is the API for this small measurement framework.
 * @author Kent Beck
 * @author Bernd Kahlbrandt, added comments.
*/
public class MethodsTimer {
	private static final int MAXIMUM_SIZE = 100_000;
	static final int ONE_SECOND = 1_000_000_000;
	private final Method[] methods;
	public MethodsTimer(Method [] methods){
		this.methods = methods;
	}
	public void report() throws Exception{
		for (Method each : methods){
			System.out.print(each.getName() + "\t");
			for (int size = 1;size <= MAXIMUM_SIZE;size*=10){
				MethodTimer r = new MethodTimer(size,each);
				r.run();
				System.out.printf(Locale.GERMAN, "Time in ms: %,2f\t\t", r.getMethodTime());
				System.out.println("Memory usage in bytes:" + r.getMethodMemoryUsage() + "\t\t\n");
			}
			System.out.println();
		}
	}
}
