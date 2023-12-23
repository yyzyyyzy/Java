import java.util.Scanner;

public class StringJoinDemo {
    public static void main(String[] args) {
        //只要有 + 连接就看作是字符串拼接
        System.out.println('哈' + 1.1); //字符类型使用ascii码和数字相加
        System.out.println("abc" + true + 1.01);
    }
}