package 接口的静态方法;

public interface A {
    /*
    1. 静态方法：必须使用static修饰，默认会被public修饰
     */
    static void test1() {
        System.out.println("静态方法");
    }
}