package 接口的默认方法;

public interface A {
    /*
    1. 默认方法：必须使用default修饰，默认会被public修饰
    2. 实例方法：对象的方法，必须使用实现类来访问
     */
    default void test1() {
        System.out.println("默认方法");
    }
}