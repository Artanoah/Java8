package benchmark;

import java.lang.reflect.Method;

import lambdaVSAnonymous.AnonymousClassTestObject;
import lambdaVSAnonymous.LambdaTestObject;
import lambdaVSReflection.LambdaRefTestObject;
import lambdaVSReflection.ReflectionLamTestObject;
import measure.MethodsTimer;
import parallelStreamsVSSerialStreams.ParallelStreamTestObject;
import parallelStreamsVSSerialStreams.SerialStreamTestObject;
import streamsVsForEach.ForEachTestObject;
import streamsVsForEach.StreamTestObject;

/**
 * Hauptklasse des entwickelten Benchmarktools. </br>
 * Diese Klasse ist der Einstiegspunkt fuer die Ausfuehrung der Benchmarks 
 * und enthaelt eine main-Methode zum Starten des Benchmarks.
 */
public class TestAll {

	/**
	 * Hauptmethode des entwickelten Benchmarktools. </br>
	 * Hier werden die zu testenden Methoden uebergeben. </br>
	 * Weitere zu testende Methoden koennen im <code>Method[]
	 * </code> namens <code>methods</code> uebergeben werden.
	 * 
	 * @param args Nicht verwendet
	 * @throws Exception Koennen aus verschiedensten Gruenden geworfen 
	 * werden die mit den verschiedenen Testmethoden zusammenhaengen.
	 */
	public static void main(String[] args) throws Exception {

		Method[] methods = new Method[]{
				ReflectionLamTestObject.class.getMethod("reflectionBenchmark", new Class[0]),
				LambdaRefTestObject.class.getMethod("lambdaBenchmark", new Class[0]),

				ForEachTestObject.class.getMethod("forEachBenchmark", new Class[0]),
				StreamTestObject.class.getMethod("streamBenchmark", new Class[0]),

				SerialStreamTestObject.class.getMethod("serialStreamBenchmark", new Class[0]),
				ParallelStreamTestObject.class.getMethod("parallelStreamBenchmark", new Class[0]),
				
				AnonymousClassTestObject.class.getMethod("anonymousClassBenchmark", new Class[0]),
				LambdaTestObject.class.getMethod("lambdaBenchmark", new Class[0])
				};

		MethodsTimer mt = new MethodsTimer(methods);
		mt.report();

	}
}
