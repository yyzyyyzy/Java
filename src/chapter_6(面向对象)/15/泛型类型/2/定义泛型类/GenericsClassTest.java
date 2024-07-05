package 定义泛型类;

public class GenericsClassTest {
    public static void main(String[] args) {
        // 使用泛型类
        定义泛型类.GenericsClass<Integer> integerBox = new 定义泛型类.GenericsClass<>();
        integerBox.setItem(123);
        System.out.println("Integer value: " + integerBox.getItem());

        定义泛型类.GenericsClass<String> stringBox = new 定义泛型类.GenericsClass<>();
        stringBox.setItem("Hello, Generics!");
        System.out.println("String value: " + stringBox.getItem());
    }
}