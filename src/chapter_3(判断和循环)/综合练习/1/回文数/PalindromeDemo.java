public class PalindromeDemo {
    public static void main(String[] args) {
        int x = 101;
        boolean result = getResult(x);
        System.out.println(result);
    }

    //给出一个整数，如果是回文整数就返回true，如果不是，就返回false
    public static boolean getResult(int x) {
        //原来的整数
        int temp = x;
        //重新组装的整数
        int num = 0;
        while (x != 0) {
            int ge = x % 10;
            x = x / 10;
            num = num * 10 + ge;
        }
        return num == temp;
    }
}