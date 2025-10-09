package Practice.Code.Daily;

import java.util.*;

public class Day12 {

	public static void main(String[] args) {
		String s = "swiss";
		char[] c = s.toCharArray(); // Convert string to char array

		// =========================
		// 1️⃣ Using HashMap
		// =========================
		Map<String, Integer> m1 = new HashMap<>();

		for (int i = 0; i < c.length; i++) {
			// Count frequency of each character
			m1.put(String.valueOf(c[i]), m1.getOrDefault(String.valueOf(c[i]), 0) + 1);
		}

		System.out.println("---- HashMap ----");
		for (Map.Entry<String, Integer> entry : m1.entrySet()) {
			// Print all characters and their counts
			System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
		}

		// =========================
		// 2️⃣ Using Array (ASCII count)
		// =========================
		int[] a = new int[256]; // Array to hold frequency of each ASCII character

		for (int i = 0; i < c.length; i++) {
			a[c[i]]++; // Increment count at index corresponding to ASCII value
		}

		System.out.println("---- Array (ASCII) ----");
		for (int i = 0; i < c.length; i++) {
			if (a[c[i]] != 0) { // Print each character only once
				System.out.println(c[i] + " -> " + a[c[i]]);
				a[c[i]] = 0; // Mark as printed
			}
		}

		// =========================
		// 3️⃣ Using TreeMap (Sorted)
		// =========================
		Map<Character, Integer> map = new TreeMap<>(); // Sorted by character

		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1); // Count frequency
		}

		System.out.println("---- TreeMap (Sorted) ----");
		map.forEach((k, v) -> System.out.println(k + " --> " + v));

		// =========================
		// 4️⃣ Using Collections.frequency
		// =========================
		List<Character> list = new ArrayList<>();
		for (char ch : s.toCharArray())
			list.add(ch); // Convert chars to a List

		Set<Character> unique = new LinkedHashSet<>(list); // Remove duplicates but preserve order

		System.out.println("---- Collections.frequency ----");
		for (char ch : unique) {
			// Count frequency using built-in method
			System.out.println(ch + " ---> " + Collections.frequency(list, ch));
		}
	}
}
