/*
当你在Java中进行方法重写时，有几个注意点需要记住：（申明不变，重写实现）

    方法名、参数列表和返回类型必须与父类的被重写方法相同。如果它们不同，那么你只是创建了一个新的方法，而不是重写父类的方法。

    访问修饰符不能比父类的被重写方法的访问修饰符更严格。例如，如果父类的方法是public，那么重写的方法可以是public或protected，但不能是private。

    重写的方法不能抛出比父类方法更多或更宽泛的异常。如果父类方法声明了一个受检查异常，那么重写的方法可以声明相同的异常、不声明异常，或者声明父类异常的子类。

    重写的方法必须具有相同的返回类型，或者是其子类。这是因为在Java中，子类方法必须能够替代父类方法。

    使用@Override注解可以帮助你检测是否正确地进行了方法重写。如果你错误地使用了注解，编译器会发出警告。

    在重写方法时，最好使用super关键字来调用父类的方法。这样可以确保你不仅仅是重写了方法，还包含了父类方法的功能。

    遵循Liskov替换原则（LSP），即子类对象应该能够替代父类对象。这意味着在重写方法时，不应该改变方法的预期行为或违背父类方法的契约。

    注意构造函数不能被重写，但可以在子类中定义一个具有相同名称的构造函数，并使用super关键字调用父类的构造函数。

通过遵循以上注意点，你可以正确地进行Java类的方法重写，并确保代码的可靠性和一致性。
 */

class Animal2 {
    public void method() {
        System.out.println("hello1");

    }

    public void method(String s) {
        System.out.println("hello1" + s);

    }
}

class Dog2 extends Animal2 {
    @Override
    public void method() {
        System.out.println("hello2");

    }

    @Override
    public void method(String s) {
        System.out.println("hello2" + s);

    }
}


public class OverrideExtendsDemo {
    public static void main(String[] args) {
        Dog2 s2 = new Dog2();
        s2.method("ww");
        s2.method();
    }
}


