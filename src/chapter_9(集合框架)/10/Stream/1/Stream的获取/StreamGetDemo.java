import java.util.*;
import java.util.stream.*;

public class StreamGetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("one", "two", "three"));
        String[] array = {"one", "two", "three"};
        int[] intArray = {1, 2, 3};
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // 1. 集合（Set）转换为 Stream
        Stream<String> stream = set.stream();

        // 2. 数组（Array）转换为 Stream
        // 数组可以使用 Arrays.stream() 或 Stream.of() 方法来转换为 Stream 流。
        Stream<String> arrayStream = Arrays.stream(array);
        IntStream intStream = Arrays.stream(intArray);

        // 3. Map 转换为 Stream
        // Map 不能直接转换为 Stream，但可以通过其 entrySet()、keySet() 或 values() 方法来获取对应的集合，
        // 然后转换为 Stream。
        // 获取 Map 的 Entry 集合并转换为 Stream
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

        // 获取 Map 的 Key 集合并转换为 Stream
        Stream<String> keyStream = map.keySet().stream();

        // 获取 Map 的 Value 集合并转换为 Stream
        Stream<Integer> valueStream = map.values().stream();
    }
}
