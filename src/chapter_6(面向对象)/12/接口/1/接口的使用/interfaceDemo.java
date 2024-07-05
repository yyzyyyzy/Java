/*
使用接口的好处：
弥补了单继承的不足，一个类可以实现多个接口
 */

interface A { //接口由常量和抽象方法组成
    //接口的成员变量默认为常量
    String NAME = "A";

    //接口的成员方法默认为抽象方法（不能有方法体）
    void testa1();

    void testa2();
}

interface B {
    void testb1();

    void testb2();
}

interface C {
    void testc1();

    void testc2();
}

//接口不能创建对象；接口是用来被类implements实现的；实现接口的类叫做实现类；
//一个类可以实现多个接口，实现类实现多个接口，必须重写全部接口的全部抽象方法，否则类需要定义为抽象类
class D implements A, B, C {

    @Override
    public void testa1() {

    }

    @Override
    public void testa2() {

    }

    @Override
    public void testb1() {

    }

    @Override
    public void testb2() {

    }

    @Override
    public void testc1() {

    }

    @Override
    public void testc2() {

    }


}