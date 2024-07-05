package 认识枚举;

public class EnumTest {
    public static void main(String[] args) {
        认识枚举.Enum light = 认识枚举.Enum.RED;
        switch (light) {
            case RED:
                System.out.println("Stop");
                break;
            case YELLOW:
                System.out.println("Slow down");
                break;
            case GREEN:
                System.out.println("Go");
                break;
        }
    }
}