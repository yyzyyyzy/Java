public class QuotientAndRemainderDemo {
    public static void main(String[] args) {
        //给定两个整数，被除数和除数（都是正数，且不超过int的范围）
        //将两数相除，要求不使用乘法、除数、和%运算符得到商和余数
        int num1 = 677;
        int num2 = 10;
        int count = 0;
        while (num1 >= num2) {
            num1 = num1 - num2;
            count++;
        }
        System.out.println(count);
        System.out.println(num1);
    }
}