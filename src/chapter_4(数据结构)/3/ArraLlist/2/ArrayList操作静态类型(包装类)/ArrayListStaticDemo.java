import java.util.ArrayList;

/*
Java 中的包装类可以将基本数据类型转换为对象，可以进行基本数据类型和对象之间的互相转换

以下是 Java 的包装类及其对应的基本数据类型：
    Integer：int
    Long：long
    Byte：byte
    Short：short
    Float：float
    Double：double
    Character：char
    Boolean：boolean
 */

public class ArrayListStaticDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);
        for (int i : list) {
            System.out.println(i);
        }
    }
}