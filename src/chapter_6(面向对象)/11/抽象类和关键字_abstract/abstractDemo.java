/*
抽象类使用的场景和好处：
    当我们知道子类需要公用的方法后，我们可以定义好抽象类（方法模板）
    让继承抽象父类的子类去重写抽象父类的方法，更好的实现多态

使用抽象类需要注意的地方：
    抽象类不能被实例化，子类必须实现抽象方法，抽象类可以拥有非抽象方法和成员变量，
    可以被继承，并且抽象类的成员变量和方法可以有不同的访问控制级别
 */

/*

什么时候适合使用抽象类：
    1. 当一组类有一些共同的行为或属性时，可以使用抽象类来定义这些共同的部分。
    例如，所有图形（如圆形、矩形等）都有计算面积的方法，您可以将这些通用行为定义在抽象类中。
    2. 当多个子类需要共享一些公共的代码逻辑时，抽象类可以提供这些公共的实现，减少代码重复。

使用抽象类的好处:
    1. 代码复用：共享抽象类中的方法和属性。
    2. 可维护性：在一个地方修改公共行为，所有子类都会受到影响。
    3. 扩展性：添加新子类时，只需实现抽象方法即可。
    4. 强制约束：子类必须实现抽象方法，确保行为一致。

 */

// 抽象类 Shape
abstract class Shape {
    final void calculate() {
        System.out.println("面积为" + calculateArea());
    }

    // 抽象方法 calculateArea() 获取面积值，并打印结果
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class abstractDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        circle.calculate();
        rectangle.calculate();
    }
}
