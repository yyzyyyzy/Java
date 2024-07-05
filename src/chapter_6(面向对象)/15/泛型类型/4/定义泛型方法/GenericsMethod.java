package 泛型方法;

public class GenericsMethod {

    // 定义一个泛型方法，接受一个泛型类型的参数并返回它
    public <T> T printAndReturn(T value) {
        System.out.println("Input value: " + value);
        return value;
    }

    // 另一个泛型方法，接受两个泛型类型参数并返回它们的组合
    public <K, V> String combine(K key, V value) {
        return key.toString() + "=" + value.toString();
    }
}