import java.util.ArrayList;
import java.util.Iterator;

/*

迭代器接口定义了几个方法，最常用的是以下三个：

    1. next() - 返回迭代器的下一个元素，并将迭代器的指针移到下一个位置。

    2. hasNext() - 用于判断集合中是否还有下一个元素可以访问。

    3. remove() - 从集合中删除迭代器最后访问的元素（可选操作）。

Java 迭代器是一种单向遍历机制，即只能从前往后遍历集合中的元素，不能往回遍历。
同时，在使用迭代器遍历集合时，不能直接修改集合中的元素，而是需要使用迭代器的 remove() 方法来删除当前元素。

 */


public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);

        Iterator<Integer> it = numbers.iterator();
        while(it.hasNext()) {
            Integer i = it.next();
            if(i < 10) {
                // 删除小于 10 的元素
                it.remove();
            }
        }
        System.out.println(numbers);
    }
}
