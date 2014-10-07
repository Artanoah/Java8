package aufgabe1;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Collections {
	public static void main(String[] args) {
		testForEach(100);
		testForEach(1000000);
		System.out.println("--------------");
		testMap(100);
		testMap(100000);
		System.out.println("--------------");
		testFilter(100);
		testFilter(100000);
		System.out.println("--------------");
		testReduce(100);
		testReduce(100000);
		System.out.println("--------------");
		testRemoveIf(100);
		testRemoveIf(100000);
		System.out.println("--------------");
	}

	public static void testFilter(int amount) {
		List<Integer> randomNumbers = generateRandomNumbers(amount);

		Queue<Integer> queue = new LinkedList<Integer>(randomNumbers);
		long start1 = System.nanoTime();
		queue.stream().filter(n -> n > 0);
		long duration1 = System.nanoTime() - start1;

		Queue<Integer> newQueue = new LinkedList<>();
		long start2 = System.nanoTime();
		for (Integer number : queue) {
			if (number > 0)
				newQueue.add(number);
		}
		long duration2 = System.nanoTime() - start2;

		System.out.println("filter lambda time: " + duration1);
		System.out.println("iterator time:      " + duration2);
	}


	public static void testMap(int amount) {
		List<Integer> randomNumbers = generateRandomNumbers(amount);

		Set<Integer> set = new TreeSet<>(randomNumbers);
		long start1 = System.nanoTime();
		set.stream().map(n -> 2*n);
		long duration1 = System.nanoTime() - start1;

		Set<Integer> newSet = new TreeSet<>();
		long start2 = System.nanoTime();
		for (Integer number : set) {
			newSet.add(number * 2);
		}
		long duration2 = System.nanoTime() - start2;

		System.out.println("map lambda time: " + duration1);
		System.out.println("iterator time:   " + duration2);
	}

	public static void testForEach(int amount) {
		List<Integer> randomNumbers = generateRandomNumbers(amount);

		List<Integer> randomNumbersMultipliedByTwo = new ArrayList<>(amount);
		long start1 = System.nanoTime();
		randomNumbers.stream().forEach(n -> randomNumbersMultipliedByTwo.add(n * 2));
		long duration1 = System.nanoTime() - start1;

		randomNumbersMultipliedByTwo.clear();
		long start2 = System.nanoTime();
		for (int number : randomNumbers) {
			randomNumbersMultipliedByTwo.add(number * 2);
		}
		long duration2 = System.nanoTime() - start2;

		System.out.println("forEach lambda time: " + duration1);
		System.out.println("iterator time:       " + duration2);
	}

	public static void testReduce(int amount) {
		List<Integer> randomNumbers = generateRandomNumbers(amount);

		long start1 = System.nanoTime();
		randomNumbers.stream().reduce(0, (a,b) -> a+b);
		long duration1 = System.nanoTime() - start1;

		long sum = 0;
		long start2 = System.nanoTime();
		for (int number : randomNumbers) {
			sum += number;
		}
		long duration2 = System.nanoTime() - start2;

		System.out.println("reduce lambda time: " + duration1);
		System.out.println("iterator time:      " + duration2);
	}

	public static void testRemoveIf(int amount) {
		List<Integer> randomNumbers = generateRandomNumbers(amount);

		CopyOnWriteArrayList<Integer> cpowal = new CopyOnWriteArrayList<>(randomNumbers);
		long start1 = System.nanoTime();
		randomNumbers.removeIf((num) -> num < 0);
		long duration1 = System.nanoTime() - start1;

		long start2 = System.nanoTime();
		for (int number : randomNumbers) {
			if (number < 0)
				randomNumbers.remove(number);
		}
		long duration2 = System.nanoTime() - start2;

		System.out.println("removeIf lambda time: " + duration1);
		System.out.println("iterator time:        " + duration2);
	}

	private static List<Integer> generateRandomNumbers(int amount) {
		int boundary = 200;
		List<Integer> randomNumbers = new ArrayList<>(amount);
		Random rnd = new Random();

		for (int i = 0; i < amount; i++) {
			randomNumbers.add(rnd.nextInt(boundary) - boundary / 2);
		}

		return randomNumbers;
	}
}
