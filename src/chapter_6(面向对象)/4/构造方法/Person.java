package 构造方法;

public class Person {

    //构造方法的作用：初始化成员变量
    //每创建一个对象，就会 显式/隐式的执行所有的 有/无参数构造方法
    private String name;
    private int age;

    //无参数的构造方法
    public Person() {
        System.out.println("这是无参数的构造方法");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("这是有参数的构造方法");
    }
}