import java.util.LinkedHashSet;
import java.util.Iterator;

public class LinkedHashSetApiDemo {
    public static void main(String[] args) {
        // 创建一个默认容量的 LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // 添加元素
        linkedHashSet.add("One");
        linkedHashSet.add("Two");
        linkedHashSet.add("Three");
        linkedHashSet.add("Four");

        System.out.println("LinkedHashSet elements after addition:");
        for (String element : linkedHashSet) {
            System.out.println(element);
        }

        // 检查是否包含某个元素
        System.out.println("LinkedHashSet contains 'Three': " + linkedHashSet.contains("Three"));

        // 删除元素
        linkedHashSet.remove("Two");
        System.out.println("LinkedHashSet elements after removal:");
        for (String element : linkedHashSet) {
            System.out.println(element);
        }

        // 获取大小
        System.out.println("LinkedHashSet size: " + linkedHashSet.size());

        // 判断是否为空
        System.out.println("LinkedHashSet is empty: " + linkedHashSet.isEmpty());

        // 迭代器
        System.out.println("LinkedHashSet elements using iterator:");
        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 转换为数组
        Object[] array = linkedHashSet.toArray();
        System.out.println("LinkedHashSet elements as array:");
        for (Object element : array) {
            System.out.println(element);
        }

        // 克隆
        LinkedHashSet<String> clonedSet = (LinkedHashSet<String>) linkedHashSet.clone();
        System.out.println("Cloned LinkedHashSet elements:");
        for (String element : clonedSet) {
            System.out.println(element);
        }

        // 清空集合
        linkedHashSet.clear();
        System.out.println("LinkedHashSet size after clear: " + linkedHashSet.size());

        // 判断是否相等
        System.out.println("LinkedHashSet equals clonedSet: " + linkedHashSet.equals(clonedSet));
    }
}
