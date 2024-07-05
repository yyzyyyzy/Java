/*

Java中的匿名内部类是一种没有命名的局部内部类，它通常用于创建一个类的实例并且只需使用一次。
匿名内部类通常用于实现接口或继承一个类，并且可以现场定义类的实现或重写方法。

 */


interface Greeting5 {
    void swim();
}

interface Swimming5 {
    void swim();
}

public class AnonymousOuter {
    public static void main(String[] args) {

        // 使用匿名内部类继承一个类
        Animal5 cat = new Animal5() {
            @Override
            public void swim() {
                System.out.println("猫猫游泳");
            }
        };
        // 调用类方法
        cat.swim();

        // 使用匿名内部类实现接口
        Greeting5 dog = new Greeting5() {
            @Override
            public void swim() {
                System.out.println("狗狗游泳");
            }
        };

        // 调用接口方法
        dog.swim();


        // 匿名内部类适用场景: 通常作为一个参数传递给一个方法
        go(new Swimming5() {
            @Override
            public void swim() {
                System.out.println("狗狗游泳");
            }
        });
        go(new Swimming5() {
            @Override
            public void swim() {
                System.out.println("猫猫游泳");
            }
        });
    }

    public static void go(Swimming5 s) {
        System.out.println("开始=================");
        s.swim();
    }
}

abstract class Animal5 {
    public abstract void swim();
}
