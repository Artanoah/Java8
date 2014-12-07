package measure;

import java.lang.reflect.Method;
import java.util.Locale;

import benchmark.CSV;

/**
 * An Example from Kent Beck in Implementation Patterns.
 * This is the API for this small measurement framework.
 * @author Kent Beck
 * @author Bernd Kahlbrandt, added comments.
*/
public class MethodsTimer {
	private static final int MAXIMUM_SIZE = 100_000;
	static final int ONE_SECOND = 1_000_000_000;
	CSV csvWriter = new CSV("output.csv");
	private final Method[] methods;
	public MethodsTimer(Method [] methods){
		this.methods = methods;
	}
	public void report() throws Exception{
		for (Method each : methods){
			System.out.print("\t##### " + each.getName() + " #####" + "\n\n");
			csvWriter.append(each.getName());
			csvWriter.makeParagraph();
			for (int size = 1;size <= MAXIMUM_SIZE;size*=10){
				MethodTimer r = new MethodTimer(size,each);
				r.run();
				int methodTime = (int) r.getMethodTime();
				int memoryUsage = (int) r.getMethodMemoryUsage();
				System.out.printf(Locale.GERMAN, "Time in ms:            %15d\n", methodTime);
				System.out.printf(Locale.GERMAN, "Memory usage in bytes: %15d\n\n", memoryUsage);

				csvWriter.append(Integer.toString(methodTime));
				csvWriter.append(Integer.toString(memoryUsage));
				csvWriter.makeParagraph();
			}
			System.out.println();
			csvWriter.makeParagraph();
		}
		csvWriter.close();
	}
}
