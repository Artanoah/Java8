package benchmark;

import java.lang.reflect.Method;
import java.util.Scanner;

import measure.MethodsTimer;
import streamsVsForEach.ForEachTestObject;
import streamsVsForEach.StreamTestObject;

public class TestAll {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		
		Method[] methods = new Method[]{ForEachTestObject.class.getMethod("forEachBenchmark", new Class[0]),
				StreamTestObject.class.getMethod("streamBenchmark", new Class[0])};
		
		MethodsTimer mt = new MethodsTimer(methods);
		mt.report();
	}
}
