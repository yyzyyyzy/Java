import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcard {

    public static void main(String[] args) {
        UnboundedWildcard example = new UnboundedWildcard();

        // 创建一个整数类型的ArrayList并调用打印方法
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        example.printList(integerList);

        // 创建一个字符串类型的ArrayList并调用打印方法
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");
        example.printList(stringList);
    }

    // 无界通配符方法，接受任意类型的ArrayList并打印元素
    public void printList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
