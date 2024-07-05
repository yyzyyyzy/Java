import java.util.ArrayList;
import java.util.List;

/*

下界通配符：
    表示泛型类型的下限。使用 <? super Type> 形式时，表示泛型可以是Type类型或Type的父类类型。
    这允许你往集合中添加Type类型或其子类类型的元素，但在读取元素时，只能确保其为Object类型，
    因为你无法确定集合中实际元素的具体类型。

 */

public class LowerboundedWildcard {

    public static void main(String[] args) {
        LowerboundedWildcard example = new LowerboundedWildcard();

        // 创建一个Number类型的ArrayList并调用添加方法
        ArrayList<Number> numberList = new ArrayList<>();
        numberList.add(1.1);
        numberList.add(2.2);
        example.addIntegers(numberList);
        System.out.println("Number list after adding integers: " + numberList);

        // 创建一个Object类型的ArrayList并调用添加方法
        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add("hello");
        objectList.add("world");
        example.addIntegers(objectList);
        System.out.println("Object list after adding integers: " + objectList);
    }

    // 下界通配符方法，接受任意类型为Integer及其父类的ArrayList，并添加新元素
    public void addIntegers(List<? super Integer> list) {
        list.add(123);
        list.add(456);
    }
}
