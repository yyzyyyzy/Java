package 关键字_final;

//常量：与类相关的变量，一旦被赋值就不能再修改，常用于存储一些固定的值，如数学常数、配置信息等
//静态常量：静态常量通常用于表示不可变的、全局共享的常量值，它们在整个程序中都可以被访问和使用，而且其值不会被改变

//final关键字可以修饰（类、方法、变量）
//修饰类：该类就是最终类，无法被继承了（工具类可能会有final）
//修饰方法：该方法就是最终方法，特点就是无法被重写
//修饰变量：该变量就是只能被赋值一次了
public class PersonTest {
    public static void main(String[] args) {
        关键字_final.Person s = new 关键字_final.Person();
        String studentLocation = s.location;
        System.out.println("Total students: " + s.getCount());
        System.out.println("Total students: " + studentLocation);
        System.out.println("Application name: " + s.APP_NAME);
        System.out.println("Application version: " + s.APP_VERSION);
        System.out.println("Database URL: " + s.DATABASE_URL);
    }
}


