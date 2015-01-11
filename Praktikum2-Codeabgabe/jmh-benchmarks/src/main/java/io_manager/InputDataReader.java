package io_manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hendrik Albers, Steffen Giersch, Maximilian Heinrich, Hector Smith, Jeremias Twele
 */

public class InputDataReader {

    /**
     * Method to create a list object with the desired number of strings read from the provided text file.
     * If the number of lines that are requested is larger than the size of the file, the reader will loop
     * back to the start of the file and continue reading.
     * @param inputFile File to be read
     * @param numberOfLines Number of lines that will be read from the file (size of returned list)
     * @return List object containing strings read from the text file
     * @throws IOException On file read error
     */
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
