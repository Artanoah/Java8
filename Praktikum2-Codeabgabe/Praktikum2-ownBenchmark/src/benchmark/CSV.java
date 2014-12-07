package benchmark;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Hilfsklasse zum erstellen einer CSV-Datei.</br>
 */
public class CSV {
	FileWriter writer;
	boolean noComma;
	
	/**
	 * Constructor der CSV-Klasse.</br>
	 * Nachdem die Methode "close()" aufgerufen wurde kann 
	 * keine andere Methode mehr auf diesem Objekt ausgefuehrt 
	 * werden.
	 * 
	 * @param fileName Name der zu erstellenden Datei.
	 */
	public CSV(String fileName) {
		try {
			writer = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noComma = true;
	}
	
	/**
	 * Haengt den String <code>value</code> an das Ende der 
	 * CSV-Datei an. Wenn noetig werden passende Kommata gesetzt
	 * 
	 * @param value Anzufuegender Wert.
	 */
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
	
	/**
	 * Macht einen Absatz in der erzeugten CSV-Datei. Damit 
	 * wird eine neue Zeile eingeleitet
	 */
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
	
	/**
	 * Schliesst die CSV-Datei. Nach ausfuehren dieser Methode 
	 * sollte keine andere Methode mehr auf dieses Objekt 
	 * ausgefuehrt werden.
	 */
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
