class Animal4 {
    String name = "父类名字";

    public void print1() {
        System.out.println("hello1");
    }
}

class Dog4 extends Animal4 {
    String name = "子类名字";

    public void showName() {
        String name = "局部名字";
        System.out.println(name); //局部名称
        System.out.println(this.name); //子类名称
        System.out.println(super.name); //父类名称
    }

    @Override
    public void print1() {
        System.out.println("hello2");
        super.print1();
    }
}

public class superDemo {
    public static void main(String[] args) {
        Dog4 d4 = new Dog4();
        d4.showName();
        d4.print1();
    }
}