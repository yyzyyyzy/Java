import java.util.Scanner;

public class PrintDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个三位数");
        int num = sc.nextInt();

        //使用占位符打印
        printByDigit(num);
        //使用连接符打印
        printByJoins(num);
    }

    public static void printByDigit(int num) {
        System.out.printf("百位：%d\n", num / 100 % 10);
        System.out.printf("十位：%d\n", num / 10 % 10);
        System.out.printf("个位：%d\n", num % 10);
    }

    public static void printByJoins(int num) {
        System.out.println("百位：" + num / 100 % 10);
        System.out.println("十位：" + num / 10 % 10);
        System.out.println("个位：" + num % 10);
    }
}