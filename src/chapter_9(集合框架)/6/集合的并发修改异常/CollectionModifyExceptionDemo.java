import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionModifyExceptionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("小友");
        list.add("大朋友");
        list.add("小朋友");
        list.add("小友小友");
        list.add("器朋友");
        list.add("中朋友");
        list.add("小友小友小友");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.contains("朋")) {
                // 尝试在迭代器遍历过程中直接删除集合元素
                // list.remove(s);

                // 避免并发修改异常的方法是，在遍历集合时不要直接修改集合的结构，使用迭代器的 remove 方法
                iterator.remove();
            }
        }
        System.out.println(list);


        //增强型 for 循环的工作机制
        //当你使用增强型 for 循环遍历集合时，编译器会将其转换为使用迭代器的方式。
        //迭代器是一种可以安全地遍历集合并在遍历过程中修改集合的机制，但是有一个前提条件：
        //只有通过迭代器自身的方法来修改集合才是安全的（如 iterator.remove()）。
//        for (String s : list) {
//            if (s.contains("朋")) {
//                list.remove(s);
//            }
//        }
//        System.out.println(list);


        //在使用普通的 for 循环遍历集合并删除元素时，如果直接使用 list.remove() 方法删除元素，
        //会导致集合的结构发生变化，从而影响到循环的正确性。具体来说，当你删除当前元素后，后续的元素会向前移动一个位置，
        //而循环变量 i 也会自增。这样就会跳过原本下一个位置的元素，
        //导致元素遍历不完整或者出现 IndexOutOfBoundsException 异常。
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("朋")) {
                list.remove(list.get(i));
                i--; // 重要：退回一个位置
            }
        }
        System.out.println(list);
    }
}