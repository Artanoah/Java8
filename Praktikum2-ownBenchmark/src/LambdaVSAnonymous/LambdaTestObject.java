package LambdaVSAnonymous;

import benchmark.Constants;
import io_manager.InputDataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LambdaTestObject {

	private List<String> list = new ArrayList<>();

	public LambdaTestObject(int size) throws IOException {
		list = InputDataReader.readFileLines(Constants.sgbWords, size);
	}

	public void lambdaBenchmark() {
		list.forEach(e -> e.toUpperCase());
	}
}
