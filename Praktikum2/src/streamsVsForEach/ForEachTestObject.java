package streamsVsForEach;

import java.util.ArrayList;
import java.util.List;

public class ForEachTestObject {
	private List<Integer> li = new ArrayList<Integer>();

	
	public ForEachTestObject(int size) {
		for(int i = 0; i < size; i++) {
			li.add((int) Math.random() * 1000);
		}
	}
	
	public void forEachBenchmark() {
		for(Integer e : li) {
			Math.sqrt(e);
		}
	}
}
