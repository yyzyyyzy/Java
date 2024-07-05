import java.util.LinkedList;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Size of stack: " + stack.size()); // Output: Size of stack: 3

        System.out.println("Top element: " + stack.peek()); // Output: Top element: 3

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
        // Output:
        // Popped element: 3
        // Popped element: 2
        // Popped element: 1

        System.out.println("Size of stack after popping: " + stack.size()); // Output: Size of stack after popping: 0
    }
}
