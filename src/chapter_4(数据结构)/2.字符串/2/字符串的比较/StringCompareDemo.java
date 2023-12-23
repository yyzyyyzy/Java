public class StringCompareDemo {
    public static void main(String[] args) {

        //不忽略大小写比较字符串的内容是否一致
        String a1 = "abc";
        String a2 = new String("abc");
        System.out.println(a1.equals(a2));

        //忽略大小写比较字符串的内容是否一致
        String b1 = "abc";
        String b2 = new String("Abc");
        System.out.println(b1.equalsIgnoreCase(b2));

        //错误比较：
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1 == s2); //地址和真实值作比较：false
    }
}