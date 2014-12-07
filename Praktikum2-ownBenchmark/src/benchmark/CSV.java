package benchmark;

import java.io.FileWriter;
import java.io.IOException;

public class CSV {
	FileWriter writer;
	boolean noComma;
	
	public CSV(String fileName) {
		try {
			writer = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noComma = true;
	}
	
	public void append(String value) {
		try {
			if(noComma) {
				writer.append(value);
			} else {
				writer.append("," + value);
			}
			
			writer.flush();
			noComma = false;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void makeParagraph() {
		try {
			writer.append("\n");
			writer.flush();
			noComma = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
