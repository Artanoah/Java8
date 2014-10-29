package streamsVsForEach;

import java.util.ArrayList;
import java.util.List;

public class StreamTestObject {
	private List<Integer> li = new ArrayList<Integer>();
	
	public StreamTestObject(int size) {
		for(int i = 0; i < size; i++) {
			li.add((int) Math.random() * 1000);
		}
	}
	
	public void streamBenchmark() {
		li.stream().forEach(e -> Math.sqrt(e));
	}

}
