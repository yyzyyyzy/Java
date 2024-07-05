package 静态内部类;

public class StaticOuterTest {
    public static void main(String[] args) {
        // 创建静态内部类实例，不需要外部类实例
        静态内部类.StaticOuter.StaticInner inner = new 静态内部类.StaticOuter.StaticInner();
        inner.display();

        // 也可以通过外部类实例来调用
        静态内部类.StaticOuter outer = new 静态内部类.StaticOuter();
        outer.invokeStaticInnerClass();
    }
}