package 接口的私有方法;

public interface A {
    /*
    1. 私有方法：必须使用private修饰
    2. 私有方法只能在接口内部被调用，不能被接口的实现类或其他类重写或继承
     */

    private void test2() {
        System.out.println("私有方法");
    }

    default void test1() {
        System.out.println("默认方法");
        test2();
    }
}