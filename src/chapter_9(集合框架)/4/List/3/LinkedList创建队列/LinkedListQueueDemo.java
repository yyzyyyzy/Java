import java.util.LinkedList;

class LinkedListQueue<T> {
    private LinkedList<T> list;

    public LinkedListQueue() {
        list = new LinkedList<>();
    }

    // 入队操作，在队尾添加元素
    public void enqueue(T element) {
        list.addLast(element);
    }

    // 出队操作，从队头移除并返回元素
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.removeFirst();
    }

    // 获取队头元素，但不移除
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.getFirst();
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 获取队列大小
    public int size() {
        return list.size();
    }
}

public class LinkedListQueueDemo {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        // 入队操作
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Size of queue: " + queue.size()); // Output: Size of queue: 3

        System.out.println("Top element: " + queue.peek()); // Output: Top element: 1

        // 出队操作
        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }
    }
}