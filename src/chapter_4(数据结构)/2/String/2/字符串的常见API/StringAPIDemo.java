public class StringAPIDemo {
    public static void main(String[] args) {
        // 比较字符串
        String str1 = "Hello, Java!";
        String str2 = "hello, java!";
        System.out.println("比较字符串 (忽略大小写): " + str1.equalsIgnoreCase(str2));

        // 遍历字符串
        System.out.print("遍历字符串: ");
        for (int i = 0; i < str1.length(); i++) {
            System.out.print(str1.charAt(i) + " ");
        }
        System.out.println();

        // 拼接字符串
        String str3 = "Learning";
        String str4 = " Java";
        String concatenated = str3.concat(str4);
        System.out.println("拼接字符串: " + concatenated);

        // 反转字符串
        String str5 = "Java";
        String reversed = new StringBuilder(str5).reverse().toString();
        System.out.println("反转字符串: " + reversed);

        // 替换字符串
        String str6 = "Hello, Java!";
        String replaced = str6.replace("Java", "World");
        System.out.println("替换字符串: " + replaced);
    }
}
