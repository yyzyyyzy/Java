package 抽象枚举;

public class AbstractEnumTest {
    public static void main(String[] args) {
        double result = 抽象枚举.AbstractEnum.ADDITION.apply(5, 3);
        System.out.println("Addition result: " + result);
    }
}