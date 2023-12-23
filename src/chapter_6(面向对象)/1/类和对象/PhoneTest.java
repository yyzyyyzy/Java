package 类和对象;

public class PhoneTest {
    public static void main(String[] args) {
        类和对象.Phone p1 = new 类和对象.Phone();

        p1.brand = "小米";
        p1.price = 1999.0;

        System.out.println(p1.brand);
        System.out.println(p1.price);

        p1.call();
        p1.playGame();

        类和对象.Phone p2 = new 类和对象.Phone();

        p2.brand = "华为";
        p2.price = 5999.0;

        System.out.println(p2.brand);
        System.out.println(p2.price);

        p2.call();
        p2.playGame();
    }
}
