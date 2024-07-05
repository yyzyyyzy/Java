public class systemDemo {
    public static void main(String[] args) {
        //1000L 用作除法操作符的右操作数，可以得到秒级的 Unix 时间戳
        long unixTimestamp = System.currentTimeMillis() / 1000L;
        System.out.println("当前时间戳：" + System.currentTimeMillis());
        System.out.println("当前时间戳：" + unixTimestamp);

        //人为终止JVM
        System.exit(0);
        System.out.println("哈哈哈");
    }
}