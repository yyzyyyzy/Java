import java.util.*;

public class CollectionNestingDemo {
    public static void main(String[] args) {
        // 示例 1: List 嵌套 Set
        List<Set<Integer>> listNestedSet = new ArrayList<>();

        // 添加子集合
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6));

        listNestedSet.add(set1);
        listNestedSet.add(set2);

        // 遍历嵌套的集合
        for (Set<Integer> set : listNestedSet) {
            System.out.println("Set contents: " + set);
        }

        // 示例 2: Map 嵌套 List
        Map<String, List<String>> mapNestedList = new HashMap<>();

        // 添加子列表
        List<String> list1 = Arrays.asList("apple", "banana", "cherry");
        List<String> list2 = Arrays.asList("orange", "grape", "kiwi");

        mapNestedList.put("fruits1", list1);
        mapNestedList.put("fruits2", list2);

        // 遍历嵌套的映射
        for (Map.Entry<String, List<String>> entry : mapNestedList.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println("Key: " + key + ", List contents: " + value);
        }
    }
}