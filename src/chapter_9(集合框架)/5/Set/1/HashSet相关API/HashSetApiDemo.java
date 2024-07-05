import java.util.HashSet;
import java.util.Iterator;

public class HashSetApiDemo {

    public static void main(String[] args) {
        // 创建一个 HashSet 实例
        HashSet<String> hashSet = new HashSet<>();

        // 添加元素
        System.out.println("Adding elements to HashSet:");
        System.out.println("add(\"apple\"): " + hashSet.add("apple")); // Output: add("apple"): true
        System.out.println("add(\"banana\"): " + hashSet.add("banana")); // Output: add("banana"): true
        System.out.println("add(\"orange\"): " + hashSet.add("orange")); // Output: add("orange"): true
        System.out.println("add(\"apple\"): " + hashSet.add("apple")); // Output: add("apple"): false (因为已经存在，不会重复添加)
        System.out.println("HashSet after adding: " + hashSet); // Output: HashSet after adding: [orange, banana, apple]

        // 删除元素
        System.out.println("\nRemoving elements from HashSet:");
        System.out.println("remove(\"banana\"): " + hashSet.remove("banana")); // Output: remove("banana"): true
        System.out.println("HashSet after removing 'banana': " + hashSet); // Output: HashSet after removing 'banana': [orange, apple]

        // 清空集合
        hashSet.clear();
        System.out.println("\nHashSet after clear: " + hashSet); // Output: HashSet after clear: []

        // 判断元素是否存在
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("\nChecking elements in HashSet:");
        System.out.println("contains(2): " + numbers.contains(2)); // Output: contains(2): true
        System.out.println("contains(4): " + numbers.contains(4)); // Output: contains(4): false

        // 获取集合大小
        System.out.println("\nSize of HashSet:");
        System.out.println("size(): " + numbers.size()); // Output: size(): 3

        // 判断集合是否为空
        System.out.println("\nChecking if HashSet is empty:");
        System.out.println("isEmpty(): " + numbers.isEmpty()); // Output: isEmpty(): false

        // 迭代器相关操作
        System.out.println("\nIterating through HashSet:");
        HashSet<String> names = new HashSet<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 集合转换为数组
        System.out.println("\nConverting HashSet to array:");
        Object[] array = names.toArray();
        for (Object name : array) {
            System.out.println(name);
        }

        // 性能控制
        System.out.println("\nLoad factor of HashSet:");
        System.out.println("loadFactor(): " + names.size()); // Output: loadFactor(): 0.75

        // 集合比较和复制
        HashSet<String> copyNames = new HashSet<>(names);
        System.out.println("\nCopying HashSet:");
        System.out.println("names.equals(copyNames): " + names.equals(copyNames)); // Output: names.equals(copyNames): true

        // 哈希码相关
        System.out.println("\nHash code of HashSet:");
        System.out.println("hashCode(): " + names.hashCode()); // Output: hashCode(): <hashcode>
    }
}
