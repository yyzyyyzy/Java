public class StringIterateDemo {
    public static void main(String[] args) {
        //方法一：使用 charAt() 方法和循环
        String str1 = "abc";

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            // 对每个字符进行操作
            System.out.println(c);
        }

        //方法二：将字符串转换为字符数组，然后使用增强型 for 循环
        String str2 = "abc";
        char[] charArray = str2.toCharArray();

        for (char c : charArray) {
            // 对每个字符进行操作
            System.out.println(c);
        }
    }
}