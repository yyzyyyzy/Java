import java.util.LinkedList;

public class LinkedListApiDemo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        //1. 添加元素
        //在链表头部添加元素：
        linkedList.addFirst("First");
        linkedList.addFirst("New First");
        System.out.println("LinkedList after adding elements at the head: " + linkedList);

        //在链表尾部添加元素：
        linkedList.addLast("Last");
        linkedList.addLast("New Last");
        System.out.println("LinkedList after adding elements at the tail: " + linkedList);

        //2. 获取元素
        //获取链表头部元素：
        String firstElement = linkedList.getFirst();
        System.out.println("First element in LinkedList: " + firstElement);

        //获取链表尾部元素：
        String lastElement = linkedList.getLast();
        System.out.println("Last element in LinkedList: " + lastElement);

        //3. 移除元素
        //移除链表头部元素：
        linkedList.removeFirst();
        System.out.println("LinkedList after removing first element: " + linkedList);

        //移除链表尾部元素：
        linkedList.removeLast();
        System.out.println("LinkedList after removing last element: " + linkedList);
    }
}