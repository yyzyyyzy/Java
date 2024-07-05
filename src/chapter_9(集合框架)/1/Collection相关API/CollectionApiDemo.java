import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionApiDemo {
    public static void main(String[] args) {
        Collection<String> list1 = new ArrayList<>();
        Collection<String> list2 = new ArrayList<>();

        //1. add(E e)
        //将指定的元素添加到集合中（如果集合不包含该元素的话）。
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Orange");
        list2.add("peach");
        list2.add("Grapes");

        //2. remove(Object o)
        //从集合中移除指定的元素（如果存在）。
        list1.remove("Banana");

        //3. size()
        //返回集合中的元素数量。
        System.out.println("Size of the collection: " + list1.size());

        //4. isEmpty()
        //判断集合是否为空。
        System.out.println("Is the collection empty? " + list1.isEmpty());

        //5. contains(Object o)
        //判断集合是否包含指定的元素。
        System.out.println("Does the collection contain 'Banana'? " + list1.contains("Banana"));
        System.out.println("Does the collection contain 'Grapes'? " + list1.contains("Grapes"));

        //6. iterator()
        //返回集合中元素的迭代器。
        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //7. clear()
        //移除集合中的所有元素。
        list1.clear();

        //8. toArray()
        //将集合转换为数组。
        Object[] array = list1.toArray();
        for (Object fruit : array) {
            System.out.println((String) fruit);
        }

        //9. addAll(Collection<? extends E> c)
        //将指定集合中的所有元素添加到当前集合中。
        list1.addAll(list2);


        for (String fruit : list1) {
            System.out.println(fruit);
        }
        for (String fruit : list2) {
            System.out.println(fruit);
        }
    }
}