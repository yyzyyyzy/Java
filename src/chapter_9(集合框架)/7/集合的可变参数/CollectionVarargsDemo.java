import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionVarargsDemo {
    public static void main(String[] args) {
        //1. 简化方法调用
        printNumbers(1, 2, 3, 4, 5);

        //2. 使用工具方法计算不同数量的整数之和
        int result1 = sum(1, 2, 3, 4, 5);
        int result2 = sum(10, 20);
        int result3 = sum();

        //3. 集合和数组初始化
        List<String> names = new ArrayList<>(List.of("Alice", "Bob", "Charlie"));
        String[] fruits = createArray("Apple", "Banana", "Orange");

        //4. 处理多个类型的输入
        printValues("Alice", 30, true, 3.14);
    }

    //1. 简化方法调用
    //可变参数使得方法调用更加简洁，不需要显式地创建数组或集合来传递多个参数。例如：
    public static void printNumbers(int... numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    //2. 创建工具方法
    //可以使用可变参数创建通用的工具方法，以处理多个输入，例如：
    public static int sum(int... numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    //2. 集合和数组初始化
    //在初始化集合或数组时，使用可变参数可以更简洁地传递初始值，例如：
    public static List<Integer> createList(Integer... numbers) {
        return Arrays.asList(numbers);
    }
    public static String[] createArray(String... values) {
        return values;
    }

    //3. 处理多个类型的输入
    //如果方法需要处理多种类型的输入，可以使用通用的 Object... 类型的可变参数，例如：
    public static void printValues(Object... values) {
        for (Object value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}