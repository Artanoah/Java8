package benchmark;

import java.lang.reflect.Method;
import java.lang.management.*;
import java.util.Scanner;

import LambdaVSAnonymous.AnonymousClassTestObject;
import LambdaVSAnonymous.LambdaTestObject;
import LambdaVSReflection.LambdaRefTestObject;
import LambdaVSReflection.ReflectionLamTestObject;
import parallelStreamsVSSerialStreams.ParallelStreamTestObject;
import parallelStreamsVSSerialStreams.SerialStreamTestObject;
import measure.MethodsTimer;
import streamsVsForEach.ForEachTestObject;
import streamsVsForEach.StreamTestObject;

public class TestAll {

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
