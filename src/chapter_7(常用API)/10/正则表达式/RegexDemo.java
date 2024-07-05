import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        // 示例文本
        String text1 = "Here are some emails: alice@example.com, bob123@domain.net, charlie@another-domain.org.";

        // 正则表达式模式，用于匹配电子邮件地址
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";

        // 创建 Pattern 对象
        Pattern pattern = Pattern.compile(emailRegex);

        // 创建 Matcher 对象
        Matcher matcher = pattern.matcher(text1);

        // 查找所有匹配的子字符串
        while (matcher.find()) {
            // 打印找到的电子邮件地址
            System.out.println("Found email: " + matcher.group());
        }

        // boolean matches(String regex)：尝试将整个输入序列与给定的正则表达式进行匹配。
        String text2 = "hello123";
        boolean isMatch = text2.matches("[a-z]+[0-9]+");
        System.out.println(isMatch);  // 输出 true

        // String replaceAll(String replacement)：替换所有匹配的子序列。
        String text3 = "The cat and the hat";
        String replacedText1 = text3.replaceAll("[a-zA-Z]at", "dog");
        System.out.println(replacedText1);  // 输出 "The dog and the dog"

        // String replaceFirst(String replacement)：替换第一个匹配的子序列。
        String text4 = "The cat and the hat";
        String replacedText2 = text4.replaceFirst("[a-zA-Z]at", "dog");
        System.out.println(replacedText2);  // 输出 "The dog and the hat"

        // String[] split(CharSequence input)：使用模式分割输入序列。
        String text5 = "one,two,three,four";
        String[] parts = text5.split(",");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}