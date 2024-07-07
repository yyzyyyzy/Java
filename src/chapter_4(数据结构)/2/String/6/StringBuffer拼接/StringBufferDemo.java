public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");

        // 添加字符串
        sb.append(" World");
        System.out.println("After append: " + sb.toString());

        // 插入字符串
        sb.insert(6, "Beautiful ");
        System.out.println("After insert: " + sb.toString());

        // 替换字符串
        sb.replace(6, 16, "Awesome");
        System.out.println("After replace: " + sb.toString());

        // 删除字符串
        sb.delete(6, 13);
        System.out.println("After delete: " + sb.toString());

        // 反转字符串
        sb.reverse();
        System.out.println("After reverse: " + sb.toString());
    }
}
