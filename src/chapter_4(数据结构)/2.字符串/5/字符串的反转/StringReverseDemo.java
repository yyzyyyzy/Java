public class StringReverseDemo {
    public static void main(String[] args) {
        String str = "Hello, World!";
        //使用 StringBuilder 或 StringBuffer 的 reverse() 方法：StringBuilder 和 StringBuffer 类都提供了 reverse() 方法，可以将字符串反转
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        String reversedStr1 = sb.toString();
        String reversedStr2 = reverseString1(str);
        String reversedStr3 = reverseString2(str);

        System.out.println(reversedStr1);
        System.out.println(reversedStr2);
        System.out.println(reversedStr3);
    }

    //将字符串转换为字符数组，然后通过交换首尾位置的字符来实现反转
    public static String reverseString1(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return new String(charArray);
    }

    //通过递归的方式将字符串反转(str.substring(1)会得到去掉第一个字符后的子字符串)
    public static String reverseString2(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString2(str.substring(1)) + str.charAt(0);
    }
}