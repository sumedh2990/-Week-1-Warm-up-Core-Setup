package Practice.Code.Daily;

import java.util.Stack;

/**
 * Day22 - Implement Queue using Two Stacks
 * ----------------------------------------
 * Queue: FIFO (First In First Out)
 * Stack: LIFO (Last In First Out)
 *
 * We will use two stacks:
 *   1️⃣ inputStack  → for enqueue (push) operations
 *   2️⃣ outputStack → for dequeue (pop) operations
 *
 * Logic:
 *   - When enqueueing, push to inputStack
 *   - When dequeueing:
 *       ▪ If outputStack is empty → move all elements from inputStack to outputStack
 *       ▪ Then pop from outputStack
 *   - This ensures queue behavior using stacks
 */
public class Day22 {

    static class MyQueue {
        private Stack<Integer> inputStack = new Stack<>();
        private Stack<Integer> outputStack = new Stack<>();

        // Enqueue → Add element to the end of queue
        public void enqueue(int x) {
            inputStack.push(x);
            System.out.println("Enqueued: " + x);
        }

        // Dequeue → Remove element from the front of queue
        public int dequeue() {
            // If both stacks are empty → queue is empty
            if (inputStack.isEmpty() && outputStack.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }

            // If outputStack is empty, move elements from inputStack
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }

            int val = outputStack.pop();
            System.out.println("Dequeued: " + val);
            return val;
        }

        // Peek → Get the front element without removing
        public int peek() {
            if (inputStack.isEmpty() && outputStack.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }

            // Transfer elements if needed
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }

            return outputStack.peek();
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }
    }

    // Test the queue
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front element: " + q.peek());  // Should print 10

        q.dequeue();  // Removes 10
        q.enqueue(40);
        q.dequeue();  // Removes 20

        System.out.println("Front element: " + q.peek());  // Should print 30

        while (!q.isEmpty()) {
            q.dequeue();  // Removes remaining elements
        }
    }
}
