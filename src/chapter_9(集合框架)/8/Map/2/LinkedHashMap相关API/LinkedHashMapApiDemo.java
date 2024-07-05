import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapApiDemo {
    public static void main(String[] args) {
        // 创建一个LinkedHashMap实例
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        // 1. put(K key, V value): 插入键值对
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");
        linkedHashMap.put(3, "Three");

        // 2. get(Object key): 获取指定键的值
        String value = linkedHashMap.get(2);
        System.out.println("Get key 2: " + value); // 输出: Get key 2: Two

        // 3. remove(Object key): 移除指定键及其对应的值
        linkedHashMap.remove(2);
        System.out.println("After removing key 2: " + linkedHashMap);

        // 4. containsKey(Object key): 检查是否包含指定键
        boolean hasKey1 = linkedHashMap.containsKey(1);
        System.out.println("Contains key 1: " + hasKey1); // 输出: Contains key 1: true

        // 5. containsValue(Object value): 检查是否包含指定值
        boolean hasValueOne = linkedHashMap.containsValue("One");
        System.out.println("Contains value 'One': " + hasValueOne); // 输出: Contains value 'One': true

        // 6. size(): 获取键值对数量
        int size = linkedHashMap.size();
        System.out.println("Size: " + size); // 输出: Size: 2

        // 7. clear(): 清空TreeMap
        linkedHashMap.clear();
        System.out.println("After clear: " + linkedHashMap); // 输出: After clear: {}

        // 8. isEmpty(): 检查是否为空
        boolean isEmpty = linkedHashMap.isEmpty();
        System.out.println("Is empty: " + isEmpty); // 输出: Is empty: true

        // 9. keySet()：返回映射中所有键的Set视图
        Set<Integer> keys = linkedHashMap.keySet();
        for (Integer key : keys) {
            System.out.println(key);
        }

        // 10. values()：返回映射中所有值的Collection视图
        Collection<String> collectionValues = linkedHashMap.values();
        for (String cValue : collectionValues) {
            System.out.println(cValue);
        }

        // 11. entrySet()：返回映射中所有键值对的Set视图
        Set<Map.Entry<Integer, String>> entries = linkedHashMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // 12. getOrDefault(Object key, V defaultValue)：返回指定键所映射的值，如果此映射不包含该键的映射关系，则返回defaultValue
        String defaultValue = linkedHashMap.getOrDefault(4, "Default");
        System.out.println(defaultValue);

        // 13. putIfAbsent(K key, V value)：如果指定的键尚未与某个值关联（或映射的值为null），则将其与给定值关联并返回null，否则返回当前值
        linkedHashMap.putIfAbsent(1, "OneAgain"); // 如果键1不存在，则插入
    }
}