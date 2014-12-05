package io_manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputDataReader {

	public static List<String> readFileLines(String inputFile, int numberOfLines) throws IOException {
		
		List<String> strList = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		
		String line;
		while ((line = reader.readLine()) != null) {
			strList.add(line);
		}
		
		reader.close();
		return strList;
	}
	
	
}
