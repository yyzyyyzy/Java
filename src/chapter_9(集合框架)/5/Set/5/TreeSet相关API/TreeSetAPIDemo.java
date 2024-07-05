import java.util.TreeSet;

public class TreeSetAPIDemo {
    public static void main(String[] args) {
        // 创建一个 TreeSet 对象
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 添加元素
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(20);
        treeSet.add(15);

        // 打印整个 TreeSet
        System.out.println("TreeSet elements: " + treeSet);

        // 判断是否包含元素
        System.out.println("Contains 10: " + treeSet.contains(10));

        // 获取第一个和最后一个元素
        Integer first = treeSet.first();
        Integer last = treeSet.last();
        System.out.println("First element: " + first);
        System.out.println("Last element: " + last);

        // 获取集合大小
        System.out.println("Size of TreeSet: " + treeSet.size());

        // 删除元素
        treeSet.remove(20);
        System.out.println("TreeSet after removing 20: " + treeSet);

        // 清空集合
        treeSet.clear();
        System.out.println("TreeSet after clearing: " + treeSet);

        // 判断是否为空
        System.out.println("TreeSet is empty: " + treeSet.isEmpty());
    }
}
