public class StringInitializationDemo {
    public static void main(String[] args) {
        // 字面量初始化
        String str1 = "Hello, Java!";
        System.out.println("字面量初始化: " + str1);

        // 用 new 关键字
        String str2 = new String("Hello, Java!");
        System.out.println("new 关键字: " + str2);

        // 从字符数组
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);
        System.out.println("字符数组: " + str3);

        // 从字节数组
        byte[] byteArray = {72, 101, 108, 108, 111};
        String str4 = new String(byteArray);
        System.out.println("字节数组: " + str4);

        // 子字符串
        String str5 = "Hello, Java!";
        String substr = str5.substring(7, 11);
        System.out.println("子字符串: " + substr);
    }
}
