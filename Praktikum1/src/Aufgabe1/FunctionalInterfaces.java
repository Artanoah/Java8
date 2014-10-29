package Aufgabe1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Maximilian Heinrich Zender
 * @author Hector Smith
 * @author Steffen Giersch
 * @author Hendrik Albers
 * @author Jeremias Jonathan Twele
 */
public class FunctionalInterfaces {

	public static void main(String[] args) {
		/*beispiel1();
		beispiel2();*/
		beispiel3();
	}

	public static void beispiel1() {
		// Alt
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Beispiel 1 Alt");
			}
		});

		// Neu
		new Thread(() -> System.out.printf("Beipsiel 1 Neu"));
	}

	public static void beispiel2() {
		JButton button = new JButton();

		// Alt
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Beispiel 2 Alt");
			}
		});

		// Neu
		button.addActionListener(e -> System.out.println("Beispiel 2 Neu"));
	}

	public static void beispiel3() {

		long start = System.nanoTime();
		// Neu
		Arrays.sort(new String[] {"hallo", "und", "guten", "morgen"}, (o1, o2) -> {
			System.out.println("Beispiel 3 Neu");
			return o1.length() - o2.length();
		});
		long finish = System.nanoTime();
		System.out.println("New took " + (finish - start) + "ns");
		
		
		start = System.nanoTime();
		// Alt
		Arrays.sort(new String[] {"hallo", "und", "guten", "morgen"}, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				System.out.println("Beispiel 3 Alt");
				return o1.length() - o2.length();
			}
		});
		finish = System.nanoTime();
		
		System.out.println("Old took " + (finish - start) + "ns");
		System.out.flush();
		
	}
}
