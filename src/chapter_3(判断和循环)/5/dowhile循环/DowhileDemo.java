public class DowhileDemo {
    public static void main(String[] args) {
        int x = 10;

        //如果x小于20的情况下，一直打印x的值
        do {
            System.out.print("value of x : " + x);
            x++;
            System.out.print("\n");
        } while (x < 20);
    }
}