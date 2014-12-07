package io_manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hilfsklasse fuer das Auslesen einer benoetigten 
 * Anzahl an Strings aus der Datei "sgb-words" fuer 
 * das Benchmarken der Testobjekte.
 */
public class InputDataReader {

	/**
	 * Liesst <code>numberOfLines</code> Strings ein und gibt 
	 * diese als <code>List&lt;String&gt;</code> zurueck. Wenn 
	 * die Datei nicht genuegend Zeilen hat, wird die Datei 
	 * wieder von vorne gelesen.
	 * 
	 * @param inputFile Datei aus der die Strings ausgelesen werden.
	 * @param numberOfLines Anzahl der Zeilen die ausgelesen werden 
	 * sollen.
	 * @return Liste mit den benoetigten Strings
	 * @throws IOException Tritt bei Fehlern beim Oeffnen oder Lesen 
	 * der Datei <code>inputFile</code> auf.
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
