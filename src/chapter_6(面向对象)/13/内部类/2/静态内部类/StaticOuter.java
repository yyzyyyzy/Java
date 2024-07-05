package 静态内部类;

/*

Java 的静态内部类是定义在另一个类内部并使用 static 修饰的类。静态内部类与非静态内部类（即成员内部类）有几点重要区别：

    1. 无需依赖外部类实例：静态内部类不依赖外部类的实例，可以直接创建实例，因此可以在没有外部类实例的情况下使用。

    2. 访问权限：静态内部类可以访问外部类的静态成员（包括私有的），但不能直接访问外部类的非静态成员和方法。

    3. 生命周期不受外部类实例的影响：静态内部类的生命周期与外部类独立，即使外部类实例被销毁，静态内部类的实例仍然可以存在。

 */

class StaticOuter {
    private static int outerStaticData = 10;
    private int outerInstanceData = 20;

    // 外部类方法，用于实例化静态内部类并调用其方法
    void invokeStaticInnerClass() {
        StaticInner inner = new StaticInner();
        inner.display();
    }

    // 静态内部类
    static class StaticInner {
        void display() {
            // 静态内部类可以访问外部类的静态成员
            System.out.println("Outer static data: " + outerStaticData);
        }
    }
}

