package 成员内部类;

/*


成员内部类（Member Inner Class）是定义在另一个类（外部类）内部的类。
它与静态内部类不同，成员内部类可以访问外部类的所有成员，包括私有成员，并且每个实例都隐含地与其外部类的实例相关联。

 */

class MemberOuter {
    private int outerData = 10;

    // 外部类方法，用于实例化内部类并调用其方法
    void invokeInnerClass() {
        MemberInner inner = new MemberInner();
        inner.display();
    }

    // 成员内部类
    class MemberInner {
        void display() {
            System.out.println("Outer data: " + outerData);
        }
    }
}

