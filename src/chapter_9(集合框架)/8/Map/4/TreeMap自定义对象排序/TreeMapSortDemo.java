/*
    为什么只有TreeMap可以对自定义对象进行排序：
        TreeMap之所以能够对自定义对象进行排序，是因为它使用了红黑树的数据结构，这种树结构能够在插入和删除元素时保持排序状态。
        TreeMap在插入元素时会根据键的自然顺序或者提供的比较器进行排序。
 */

import java.util.*;

// 自定义对象
class TreeMapSort implements Comparable<TreeMapSort> {
    private int id;
    private String name;

    public TreeMapSort(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 省略 getter 和 setter 方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 实现 compareTo 方法，定义排序规则
    @Override
    public int compareTo(TreeMapSort o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "MyObject{id=" + id + ", name='" + name + "'}";
    }
}

public class TreeMapSortDemo {
    public static void main(String[] args) {
        // 创建 TreeMap，无需传入 Comparator，因为自定义对象实现了 Comparable 接口
        TreeMap<TreeMapSort, String> treeMap = new TreeMap<>();

        // 插入自定义对象到 TreeMap
        treeMap.put(new TreeMapSort(2, "Alice"), "Value 2");
        treeMap.put(new TreeMapSort(1, "Bob"), "Value 1");
        treeMap.put(new TreeMapSort(3, "Charlie"), "Value 3");

        // 遍历 TreeMap，按照自定义 Comparator 的排序顺序输出
        for (Map.Entry<TreeMapSort, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
