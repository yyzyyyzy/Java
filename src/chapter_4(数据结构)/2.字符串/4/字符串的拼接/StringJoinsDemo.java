import java.util.StringJoiner;

public class StringJoinsDemo {
    public static void main(String[] args) {
        String str1 = "lzk";
        String str2 = "lzk";
        String str3 = "lzk";

        //单线程拼接字符串使用StringBuilder
        //多线程拼接字符串使用StringBuffer
        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        sb.append(str2);
        sb.append(str3);
        String result1 = sb.toString();
        System.out.println(result1);

        //使用分隔符拼接字符串
        StringJoiner joiner1 = new StringJoiner(",");
        joiner1.add(str1);
        joiner1.add(str2);
        joiner1.add(str3);
        String result2 = joiner1.toString();
        System.out.println(result2);

        //使用分隔符、前缀、后缀拼接字符串
        StringJoiner joiner2 = new StringJoiner(",", "[", "]");
        joiner2.add(str1);
        joiner2.add(str2);
        joiner2.add(str3);
        String result3 = joiner2.toString();
        System.out.println(result3);
    }
}