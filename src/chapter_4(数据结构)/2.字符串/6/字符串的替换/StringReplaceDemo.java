public class StringReplaceDemo {
    public static void main(String[] args) {
        String s1 = "aaaaaaabc";
        System.out.println(s1.replace("a", "b"));

        //找到第一个需要替换字符的索引，并进行替换
        String s2 = "aaaaaaab";
        System.out.println(s2.replaceFirst("a", "b"));
    }
}