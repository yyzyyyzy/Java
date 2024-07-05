import java.util.HashMap;
import java.util.Map;

public class HashMapApiDemo {
    public static void main(String[] args) {
        // 创建一个HashMap实例
        Map<String, Integer> map = new HashMap<>();

        // 添加键值对
        map.put("apple", 10);
        map.put("orange", 5);
        map.put("banana", 8);

        // 遍历方式一：使用 entrySet() 方法获取键值对集合，然后使用增强型 for 循环遍历
        System.out.println("遍历方式一：使用 entrySet()");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

        // 遍历方式二：遍历键集合，然后获取值
        System.out.println("遍历方式二：遍历键集合");
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        // 遍历方式三：使用 forEach() 方法遍历（Java 8+）
        System.out.println("遍历方式三：使用 forEach()");
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        // 判断是否包含某个键或值
        System.out.println("判断是否包含某个键或值");
        System.out.println("Contains key 'apple': " + map.containsKey("apple"));
        System.out.println("Contains value 5: " + map.containsValue(5));

        // 获取键值对数量
        System.out.println("HashMap 中键值对的数量：" + map.size());

        // 获取所有值
        System.out.println("HashMap 所有值的集合：" + map.values());

        // 删除键值对
        map.remove("banana");
        System.out.println("删除键为 'banana' 后的 HashMap：");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 清空 HashMap
        map.clear();
        System.out.println("清空 HashMap 后，大小为：" + map.size());
    }
}
