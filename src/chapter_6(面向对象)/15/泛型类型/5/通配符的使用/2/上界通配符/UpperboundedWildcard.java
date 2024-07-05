import java.util.ArrayList;
import java.util.List;

/*

上界通配符：
    表示泛型类型的上限，在使用 <? extends Type> 形式时，表示泛型可以是Type类型或Type的子类类型。
    这样做的好处是，你可以安全地读取类型为上限类型或其子类型的元素，但无法往这个集合中添加元素，
    因为你无法确定要添加的元素是上限类型的哪个子类型。

 */


public class UpperboundedWildcard {

    public static void main(String[] args) {
        UpperboundedWildcard example = new UpperboundedWildcard();

        // 创建一个整数类型的ArrayList并调用打印方法
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        example.printNumbers(integerList);

        // 创建一个双精度浮点数类型的ArrayList并调用打印方法
        ArrayList<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);
        example.printNumbers(doubleList);
    }

    // 上界通配符方法，接受任意类型为Number及其子类的ArrayList并打印元素
    public void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
    }
}
