package 多态的使用;
/*
    多态：
        1. 多态是继承/实现的表现的一种形象，表现为：对象多态，行为多态
        2. 首先需要有继承关系，存在父类引用子类的对象，存在方法重写
        3. 多态是对象的多态，方法的多态，并不是成员变量的多态
 */

public class polymorphismDemo {
    public static void main(String[] args) {
        // 目标：理解多态的好处
        // 好处1：可以实现解耦合，右边对象可以随便切换
        多态的使用.HumanBeing p = new 多态的使用.Police();
        多态的使用.HumanBeing d = new 多态的使用.Doctor();

        /*
            在多态的使用中，虽然子类重写了父类的属性和方法，但是当通过父类类型的变量引用子类实例时，
            该变量仍然只能访问到父类的成员。这是因为编译器在编译时只考虑变量的类型，
            而不考虑变量所指向的对象的类型。因此，在polymorphismDemo类的main()方法中，
            当使用HumanBeing类型的变量p和d分别引用Police实例和Doctor实例时，
            它们都只能访问到HumanBeing类中定义的name属性，而无法访问子类中重写的name属性。
         */
        System.out.println(p.name);

        p.run();
        d.run();


        // 好处2：可以在公用方法使用父类类型的变量作为形参，可以接收一切子类对象
        hello(p);
        hello(d);

        /*
            如果希望使用子类的方法的时候可以使用强制类型转换，最好在强制类型转换之前使用
            instanceof去判断这个对象的真实类型
         */
        if (p instanceof 多态的使用.Police) {
            多态的使用.Police p1 = (多态的使用.Police) p;
            p1.shoot();
        }
        if (d instanceof 多态的使用.Doctor) {
            多态的使用.Doctor d1 = (多态的使用.Doctor) d;
            d1.care();
        }
    }

    public static void hello(多态的使用.HumanBeing h) {
        System.out.println("这个方法可以接收父类对象以及继承父类对象的所有子类对象");
    }
}


