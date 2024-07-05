import java.util.*;
import java.util.stream.Collectors;

public class StreamMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        Map<String, List<Integer>> myMap = new HashMap<>();
        myMap.put("one", Arrays.asList(1, 2, 3));
        myMap.put("two", Arrays.asList(4, 5, 6));
        myMap.put("three", Arrays.asList(7, 8, 9));

        // 过滤出值大于2的元素
        Map<String, Integer> filteredMap = map.entrySet().stream()
                .filter(entry -> entry.getValue() > 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // 将值转换为其平方
        Map<String, Integer> squaredMap = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() * entry.getValue()));

        // 按值排序
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        // 按值去重：由于 Map 本身是基于键唯一的，因此去重操作通常是针对值进行的
        Map<String, Integer> distinctMap = map.entrySet().stream()
                .filter(new HashSet<>()::add)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // 只保留前 2 个元素
        Map<String, Integer> limitedMap = map.entrySet().stream()
                .limit(2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // 跳过前 2 个元素
        Map<String, Integer> skippedMap = map.entrySet().stream()
                .skip(2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // 将多个列表合并为一个列表
        List<Integer> flatList = myMap.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());


        System.out.println("Filtered map: " + filteredMap);
        System.out.println("Squared map: " + squaredMap);
        System.out.println("Sorted map: " + sortedMap);
        System.out.println("Limited map: " + limitedMap);
        System.out.println("Skipped map: " + skippedMap);
        System.out.println("Flattened list: " + flatList);
    }
}