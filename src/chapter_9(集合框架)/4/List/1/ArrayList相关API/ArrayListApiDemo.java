import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayListApiDemo {
    public static void main(String[] args) {
        //1. 创建和初始化 List
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");

        //2. 访问 List 中的元素
        System.out.println(fruits.get(0)); // 输出 "apple"
        System.out.println(fruits.get(1)); // 输出 "banana"

        //3. 遍历 List
        //使用增强 for 循环遍历 List：
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        //使用迭代器遍历 List：
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //使用 forEach 方法和 Lambda 表达式遍历 List：
        // 使用 Lambda 表达式
        fruits.forEach(fruit -> System.out.println(fruit));

        // 使用方法引用
        fruits.forEach(System.out::println);

        //4. 修改 List 中的元素
        fruits.set(1, "blueberry");
        System.out.println(fruits); // 输出 [apple, blueberry, cherry]

        //5. 删除 List 中的元素
        //使用 remove 方法删除 List 中的元素：
        // 删除元素
        fruits.remove("banana"); // 按值删除
        fruits.remove(0); // 按索引删除
        System.out.println(fruits); // 输出 [cherry]

        //6. List 的其他常用方法
        //一些其他常用的方法包括 contains、indexOf、size 和 clear：
        // 检查是否包含元素 contains
        System.out.println(fruits.contains("banana")); // 输出 true

        // 获取元素的索引 indexOf
        System.out.println(fruits.indexOf("cherry")); // 输出 2

        // 获取 List 的大小size
        System.out.println(fruits.size()); // 输出 3

        // 清空 List clear
        fruits.clear();
        System.out.println(fruits); // 输出 []

        //7. 使用 LinkedList
        //LinkedList 是 List 接口的另一个常用实现，与 ArrayList 的用法类似，但在插入和删除操作上有不同的性能表现：
        List<String> fruit = new LinkedList<>();
        fruit.add("apple");
        fruit.add("banana");
        fruit.add("cherry");

        // 遍历 LinkedList
        fruit.forEach(System.out::println);
    }
}