import java.util.*;

public class TreeMapApiDemo {

    public static void main(String[] args) {
        // 创建一个TreeMap实例
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // put(K key, V value): 插入键值对
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(3, "Three");

        // get(Object key): 获取指定键的值
        String value = treeMap.get(2);
        System.out.println("Value for key 2: " + value);

        // remove(Object key): 移除指定键及其对应的值
        treeMap.remove(2);
        System.out.println("After removing key 2: " + treeMap);

        // containsKey(Object key): 检查是否包含指定键
        boolean hasKey = treeMap.containsKey(1);
        System.out.println("Contains key 1: " + hasKey);

        // containsValue(Object value): 检查是否包含指定值
        boolean hasValue = treeMap.containsValue("One");
        System.out.println("Contains value 'One': " + hasValue);

        // size(): 获取键值对数量
        int size = treeMap.size();
        System.out.println("Size of the TreeMap: " + size);

        // clear(): 清空TreeMap
        treeMap.clear();
        System.out.println("After clear: " + treeMap);

        // isEmpty(): 检查是否为空
        boolean isEmpty = treeMap.isEmpty();
        System.out.println("Is TreeMap empty: " + isEmpty);

        // keySet(): 获取所有键的Set视图
        treeMap.put(4, "Four");
        treeMap.put(5, "Five");
        treeMap.put(6, "Six");
        Set<Integer> keys = treeMap.keySet();
        System.out.println("Keys: " + keys);

        // values(): 获取所有值的Collection视图
        Collection<String> values = treeMap.values();
        System.out.println("Values: " + values);

        // entrySet(): 获取所有键值对的Set视图
        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();
        System.out.println("Entries: " + entries);

        // getOrDefault(Object key, V defaultValue): 获取指定键的值或默认值
        String defaultValue = treeMap.getOrDefault(7, "Default");
        System.out.println("Value for key 7 or default: " + defaultValue);

        // putIfAbsent(K key, V value): 如果键不存在则插入
        treeMap.putIfAbsent(4, "FourAgain");
        System.out.println("After putIfAbsent: " + treeMap);

        // firstKey(): 获取最小的键
        Integer firstKey = treeMap.firstKey();
        System.out.println("First key: " + firstKey);

        // lastKey(): 获取最大的键
        Integer lastKey = treeMap.lastKey();
        System.out.println("Last key: " + lastKey);

        // higherKey(K key): 获取大于给定键的最小键
        Integer higherKey = treeMap.higherKey(4);
        System.out.println("Higher key than 4: " + higherKey);

        // lowerKey(K key): 获取小于给定键的最大键
        Integer lowerKey = treeMap.lowerKey(6);
        System.out.println("Lower key than 6: " + lowerKey);

        // subMap(K fromKey, K toKey): 获取子Map，包含fromKey，不包含toKey
        SortedMap<Integer, String> subMap = treeMap.subMap(4, 6);
        System.out.println("SubMap from 4 to 6: " + subMap);

        // headMap(K toKey): 获取键小于toKey的子Map
        SortedMap<Integer, String> headMap = treeMap.headMap(5);
        System.out.println("HeadMap up to 5: " + headMap);

        // tailMap(K fromKey): 获取键大于等于fromKey的子Map
        SortedMap<Integer, String> tailMap = treeMap.tailMap(5);
        System.out.println("TailMap from 5: " + tailMap);
    }
}
