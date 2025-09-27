package Practice.Code.Daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day2 {

    public static void main(String[] args) {

        // ✅ First Example — Find missing numbers between first and last element (using simple loop)
        int missingNo[] = {1, 2, 3, 4, 6, 7, 9}; // Missing numbers: 5, 8

        // Store the start and end range based on array values
        int start = missingNo[0];
        int end = missingNo[missingNo.length - 1];

        System.out.println("start : " + start + " end : " + end);
        System.out.println("Missing numbers are:");

        int j = 0; // Pointer to traverse array elements

        // Loop from the smallest to largest number in the array
        for (int i = start; i <= end; i++) {
            // If the number exists in array, move to next
            if (j < missingNo.length && missingNo[j] == i) {
                j++;
            } 
            // Otherwise, print the missing number
            else {
                System.out.println(i);
            }
        }

        // ✅ Second Example — Using HashSet to find missing numbers in the full range (1..n)
        int arr[] = {7, 8, 2, 4, 5, 6}; // Missing numbers: 1, 3
        int n = 8; // Total range (1 to n)

        // Store all numbers in a HashSet for O(1) lookup
        Set<Integer> s1 = new HashSet<>();
        for (int i : arr) {
            s1.add(i);
        }

        System.out.println("Missing numbers are (HashSet):");
        // Loop through all numbers in range 1..n and check if missing
        for (int i = 1; i <= n; i++) {
            if (!s1.contains(i)) {
                System.out.println(i);
            }
        }

        // ✅ Third Example — Using Boolean Array (index-based presence tracking)
        boolean[] present = new boolean[n + 1]; // Create boolean array of size n+1

        // Mark existing numbers as true
        for (int num : arr) {
            if (num <= n) {
                present[num] = true;
            }
        }

        System.out.println("Missing numbers are (Boolean Array):");
        // Print numbers that are not marked as present
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                System.out.println(i);
            }
        }

        // ✅ Fourth Example — Using Java Streams (Modern Functional Approach)
        Set<Integer> set = Arrays.stream(arr)
                                 .boxed() // Convert int -> Integer
                                 .collect(Collectors.toSet()); // Collect as Set

        System.out.println("Missing numbers are (Streams):");
        // Generate numbers 1..n and filter out the ones missing from the set
        IntStream.rangeClosed(1, n)
                 .filter(i -> !set.contains(i))
                 .forEach(System.out::println);
    }
}
