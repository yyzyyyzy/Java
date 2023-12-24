class Static {
    static int age = 19;

    static {
        System.out.println("这是类代码块"); //只会在类加载的时候执行一次（单例模式），可以对类变量进行初始化赋值
    }

    {
        System.out.println("这是实例代码块"); //只有在创建实例对象的时候执行
    }

    Static() {
        System.out.println("这是构造函数"); //只有在创建实例对象的时候执行
    }
}

public class staticTest {
    public static void main(String[] args) {
        Static s = new Static();
        System.out.println(Static.age);
    }
}