package Practice.Code.Daily;

/**
 * Day19 - Rotate Array by K Steps
 * 
 * Problem: Given an array, rotate it to the right by k steps.
 * Example: [1,2,3,4,5,6,7], k=3 → [5,6,7,1,2,3,4]
 * 
 * Two Approaches:
 *  1. Using Extra Array (rotate1)
 *  2. Using Reverse Algorithm (rotate)
 */
public class Day19 {

    /**
     * Approach 1: Using Extra Array
     * --------------------------------
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Logic:
     * - Create a new array (temp)
     * - Place each element at its new rotated position: (i + k) % n
     * - Copy back to the original array
     */
    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        
        // Step 1: Place elements in rotated positions
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        
        // Step 2: Copy elements back to original array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * Approach 2: Using Reversal Algorithm
     * -------------------------------------
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Logic:
     * 1. Reverse entire array
     * 2. Reverse first k elements
     * 3. Reverse remaining n - k elements
     *
     * Example:
     * Original: [1,2,3,4,5,6,7], k=3
     * Step 1 → Reverse all: [7,6,5,4,3,2,1]
     * Step 2 → Reverse first 3: [5,6,7,4,3,2,1]
     * Step 3 → Reverse rest: [5,6,7,1,2,3,4]
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle case when k > n

        // Step 1: Reverse entire array
        reverse(nums, 0, n - 1);
        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse remaining n - k elements
        reverse(nums, k, n - 1);
    }

    /**
     * Helper method to reverse elements in array
     * between given start and end indices
     */
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Main method to test both approaches
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        // Using reversal algorithm
        rotate(nums, k);
        // Using extra array (optional test)
        // rotate1(nums, k);

        System.out.print("Rotated Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
