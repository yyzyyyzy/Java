class Singleton {

    // 私有类变量，用于保存单例对象
    private static Singleton instance = new Singleton();

    // 私有构造函数，防止外部直接创建对象
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton once1 = Singleton.getInstance();
        Singleton once2 = Singleton.getInstance();

        //得到的地址相同，单例模式验证成功
        System.out.println(once1);
        System.out.println(once2);
    }
}