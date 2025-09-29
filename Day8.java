package Practice.Code.Daily;

import java.util.Arrays;

public class Day8 {

    public static void main(String[] args) {
        
        int target = 7; // Element to find
        int a[] = {3, 7, 8, 4, 6, 5, 9};

        // Step 1: Sort the array (Binary search works only on sorted data)
        Arrays.sort(a);

        System.out.println("✅ Sorted Array:");
        for (int num : a) {
            System.out.print(num + " ");
        }

        // Step 2: Define two pointers for manual binary search
        int left = 0;
        int right = a.length - 1;
        boolean found = false;

        // Step 3: Perform iterative binary search
        while (left <= right) {

            // Step 4: Find middle index (divides array in half)
            int mid = (left + right) / 2;

            // Step 5: Compare middle element with target
            if (a[mid] == target) {
                System.out.println("\n\n🔹 Iterative Search: Element " + target + " found at index " + mid);
                found = true;
                break; // Exit loop after finding element
            } 
            // Step 6: If target is smaller → move to left half
            else if (a[mid] > target) {
                right = mid - 1;
            } 
            // Step 7: If target is greater → move to right half
            else {
                left = mid + 1;
            }
        }

        // Step 8: Element not found by manual search
        if (!found) {
            System.out.println("\n\n❌ Iterative Search: Element " + target + " not found in the array.");
        }

        // -----------------------------------------------
        // Step 9: Use inbuilt binary search method (shortcut)
        // -----------------------------------------------
        int index = Arrays.binarySearch(a, target);

        if (index >= 0)
            System.out.println("\n🔹 Inbuilt Search: Element " + target + " found at index " + index);
        else
            System.out.println("\n❌ Inbuilt Search: Element not found.");

        // -----------------------------------------------
        // Step 10: Use recursive binary search method
        // -----------------------------------------------
        int result = binarySearch(a, 0, a.length - 1, target);

        if (result != -1)
            System.out.println("\n🔹 Recursive Search: Element " + target + " found at index " + result);
        else
            System.out.println("\n❌ Recursive Search: Element " + target + " not found.");
    }

    /**
     * Recursive Binary Search Implementation
     * --------------------------------------
     * @param arr   Sorted array
     * @param left  Left boundary
     * @param right Right boundary
     * @param target Element to find
     * @return index of target if found, otherwise -1
     */
    static int binarySearch(int[] arr, int left, int right, int target) {
        // Base condition: when search space is empty
        if (left > right)
            return -1;

        // Find the middle index
        int mid = (left + right) / 2;

        // Check if the middle element is the target
        if (arr[mid] == target)
            return mid;

        // If target is smaller, search left half
        else if (arr[mid] > target)
            return binarySearch(arr, left, mid - 1, target);

        // If target is greater, search right half
        else
            return binarySearch(arr, mid + 1, right, target);
    }
}
