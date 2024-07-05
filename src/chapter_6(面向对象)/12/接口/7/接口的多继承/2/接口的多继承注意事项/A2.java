/*

接口的注意事项：
    1. 一个接口继承多个接口，如果多个接口中的方法签名冲突，那么此时接口不支持多继承
    2. 一个类实现多个接口，如果多个接口中的方法签名冲突，那么此时类不支持多实现
    3. 一个类继承了父类，同时实现了接口，父类中和接口中有同名的默认方法，实现类会优先使用父类的
    4. 一个类实现了多个接口，多个接口中存在同名的默认方法，可以不冲突，这个类重写方法就可以了

*/

interface I1 {
    void hello();
}

interface J1 {
    String hello();
}

//interface k1 extends I1, J1 {
// 一个接口继承多个接口，如果多个接口中的方法签名冲突，那么此时接口不支持多继承
//}

//class P1 implements I1, J1 {
// 一个类实现多个接口，如果多个接口中的方法签名冲突，那么此时类不支持多实现
//}

interface O {
    default void run() {
        System.out.println("接口中的run方法");
    }
}

interface IT1 {
    default void test1() {
        System.out.println("IT1");
    }
}

interface IT2 {
    default void test1() {
        System.out.println("IT2");
    }
}

class FatherClass {
    public void run() {
        System.out.println("父类的run方法");
    }
}

class SonClass extends FatherClass implements O {

}

public class A2 {
    public static void main(String[] args) {
        // 一个类继承了父类，同时实现了接口，父类中和接口中有同名的默认方法，实现类会优先使用父类的
        SonClass sonClass = new SonClass();
        sonClass.run();
    }
}

class N implements IT1, IT2 {
    // 一个类实现了多个接口，多个接口中存在同名的默认方法，可以不冲突，这个类重写方法就可以了
    @Override
    public void test1() {
        System.out.println("自己的test1方法");
    }

}

