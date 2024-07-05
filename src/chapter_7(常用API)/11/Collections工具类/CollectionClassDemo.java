import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionClassDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(5, 2, 8, 1, 3));
        List<String> list = new ArrayList<>();
        List<String> strings = new ArrayList<>(List.of("Alice", "Bob", "Charlie"));

        //1. sort(List<T> list)
        //用于对列表进行排序。
        Collections.sort(numbers);
        System.out.println(numbers);  // 输出：[1, 2, 3, 5, 8]

        //2. binarySearch(List<? extends Comparable<? super T>> list, T key)
        //用于在已排序的列表中执行二分查找。
        int index = Collections.binarySearch(numbers, 3);
        System.out.println("Index of 3: " + index);  // 输出：Index of 3: 2

        //3. synchronizedList(List<T> list)
        //用于返回一个线程安全的列表包装器。
        List<String> synchronizedList = Collections.synchronizedList(list);
        synchronizedList.add("Alice");
        synchronizedList.add("Bob");
        synchronized (synchronizedList) {
            for (String name : synchronizedList) {
                System.out.println(name);
            }
        }

        //4. fill(List<? super T> list, T obj)
        //用指定的对象填充整个列表。
        Collections.fill(numbers, 5);
        System.out.println(numbers);  // 输出：[5, 5, 5, 5, 5]

        //5. unmodifiableList(List<? extends T> list)
        //用于返回一个不可修改的列表视图。
        List<String> unmodifiableList = Collections.unmodifiableList(strings);
        // 试图修改不可修改的列表将抛出 UnsupportedOperationException
        // unmodifiableList.add("David");
        System.out.println(unmodifiableList);  // 输出：[Alice, Bob, Charlie]

        //6. reverse(List<?> list)
        //用于反转列表中的元素顺序。
        Collections.reverse(numbers);
        System.out.println(numbers);  // 输出：[5, 4, 3, 2, 1]

        //7. shuffle(List<?> list)
        //用于随机重排列表中的元素顺序。
        Collections.shuffle(numbers);
        System.out.println(numbers);  // 输出类似于 [3, 5, 2, 1, 4] 的随机顺序
    }
}
