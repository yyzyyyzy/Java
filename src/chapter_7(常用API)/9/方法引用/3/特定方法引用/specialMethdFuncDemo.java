import java.util.Arrays;
import java.util.Comparator;

/*
    1. String::compareToIgnoreCase 是类 String 的任意对象的实例方法引用。
    2. Arrays.sort 方法需要一个 Comparator 类型的参数，String::compareToIgnoreCase 符合这个要求，
       因为 compareToIgnoreCase 方法的签名与 Comparator 接口的 compare 方法的签名匹配。
    3. compareToIgnoreCase 是一个实例方法，它的第一个参数是调用该方法的字符串对象，第二个参数是要比较的另一个字符串。
 */


public class specialMethdFuncDemo {
    public static void main(String[] args) {
        // 创建一个 String 类型的列表
        String[] names = {"Alice", "Bob", "Charlie", "David"};

        // 使用匿名内部类实现接口改写方法
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        // 使用Lambda表达式定义函数式接口的实例
        Arrays.sort(names, (o1, o2) -> o1.compareToIgnoreCase(o2));

        // 使用特定实例方法引用来按长度对列表进行排序
        Arrays.sort(names, String::compareToIgnoreCase);

        // 输出排序后的列表
        System.out.println("Sorted names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}