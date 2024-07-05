package 泛型方法;

public class GenericMethodTest {
    public static void main(String[] args) {
        泛型方法.GenericsMethod example = new 泛型方法.GenericsMethod();

        // 使用第一个泛型方法，传入整数并打印返回值
        Integer intValue = example.printAndReturn(123);
        System.out.println("Returned Integer value: " + intValue);

        // 使用第一个泛型方法，传入字符串并打印返回值
        String strValue = example.printAndReturn("Hello, Generics!");
        System.out.println("Returned String value: " + strValue);

        // 使用第二个泛型方法，传入不同类型的参数并组合成字符串
        String combinedValue = example.combine("key", 456);
        System.out.println("Combined value: " + combinedValue);
    }
}