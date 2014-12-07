package LambdaVSAnonymous;

import benchmark.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AnonymousClassTestObject {

	private List<String> list = new ArrayList<>();

	public AnonymousClassTestObject(int size) throws IOException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
	}

	public void anonymousClassBenchmark() {
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				s.toUpperCase();
			}
		});
	}
}