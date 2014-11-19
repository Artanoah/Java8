package streamsVsForEach;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import benchmark.Constants;


public class ForEachTestObject {
//	private List<Integer> li = new ArrayList<Integer>();
	private List<String> li = new ArrayList<String>();
	
	public ForEachTestObject(int size) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(Constants.sgbWords));
		
		while(br.ready()) {
			li.add(br.readLine());
		}
	}
	
	public void forEachBenchmark() {
		for(Integer e : li) {
			Math.sqrt(e);
		}
	}
}
