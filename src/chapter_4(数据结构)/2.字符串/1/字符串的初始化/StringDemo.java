public class StringDemo {
    public static void main(String[] args) {

        //基本构造字符串
        String s1 = "lzk";

        //空参数构造字符串
        String s2 = new String();
        s2 = "lzk";

        //有参数构造字符串
        String s3 = new String("lzk");

        //字符数组构造字符串
        char[] c1 = {'a', 'b', 'c', 'd'};
        String s4 = new String(c1);

        //字节数组构造字符串
        byte[] b1 = {11, 22, 33, 44};
        String s5 = new String(b1);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }
}