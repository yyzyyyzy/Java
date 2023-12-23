import 静态变量和常量.*;

//静态变量：与类相关的变量，具有唯一性和共享性，常用于存储可变的数据，如计数器、全局状态等
//常量：与类相关的变量，一旦被赋值就不能再修改，常用于存储一些固定的值，如数学常数、配置信息等
//静态常量：静态常量通常用于表示不可变的、全局共享的常量值，它们在整个程序中都可以被访问和使用，而且其值不会被改变
public class PersonTest {
    public static void main(String[] args) {
        静态变量和常量.Person s = new 静态变量和常量.Person();
        String studentLocation = s.location;
        System.out.println("Total students: " + s.getCount());
        System.out.println("Total students: " + studentLocation);
        System.out.println("Application name: " + s.APP_NAME);
        System.out.println("Application version: " + s.APP_VERSION);
        System.out.println("Database URL: " + s.DATABASE_URL);
    }
}


