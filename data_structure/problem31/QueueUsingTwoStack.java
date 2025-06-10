package data_structure.problem31;

import java.io.*;
import java.util.*;

public class QueueUsingTwoStack {

    static class MyQueue {
        Stack<Integer> stackNewestOnTop = new Stack<>();
        Stack<Integer> stackOldestOnTop = new Stack<>();

        public void enqueue(int x) {
            stackNewestOnTop.push(x);
        }

        public void shiftStacks() {
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }

        public void dequeue() {
            shiftStacks();
            if (!stackOldestOnTop.isEmpty()) {
                stackOldestOnTop.pop();
            }
        }

        public int peek() {
            shiftStacks();
            return stackOldestOnTop.peek();
        }
    }

    public static void main(String[] args) throws IOException {
        MyQueue queue = new MyQueue();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(reader.readLine());

        while (q-- > 0) {
            String[] parts = reader.readLine().split(" ");
            int type = Integer.parseInt(parts[0]);

            if (type == 1) {
                int x = Integer.parseInt(parts[1]);
                queue.enqueue(x);
            } else if (type == 2) {
                queue.dequeue();
            } else if (type == 3) {
                System.out.println(queue.peek());
            }
        }
    }
}
