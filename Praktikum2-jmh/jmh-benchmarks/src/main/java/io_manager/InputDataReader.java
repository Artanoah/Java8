package io_manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputDataReader {

	public static List<String> readFileLines(String inputFile, int numberOfLines) throws IOException {
		
		if (numberOfLines <= 0) {
			throw new IllegalArgumentException("Invalid number of lines: " + numberOfLines);
		}
		if (inputFile == null || inputFile.isEmpty()) {
			throw new IllegalArgumentException("Invalid input file: " + inputFile);
		}
		
		List<String> strList = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		
		String line;
		for (int i = 0; i < numberOfLines; i++) {
			//	Read line
			line = reader.readLine();
			
			//	Test for EOF
			if (line == null) {
				//	Reset reader to file start
				reader.close();
				reader = new BufferedReader(new FileReader(inputFile));
				
				//	Read new line
				line = reader.readLine();
				if (line == null) {
					reader.close();
					throw new IOException("Problems reading file: " + inputFile);
				}
			}
			strList.add(line);			
		}
		
		reader.close();
		return strList;
	}
	
	
}
