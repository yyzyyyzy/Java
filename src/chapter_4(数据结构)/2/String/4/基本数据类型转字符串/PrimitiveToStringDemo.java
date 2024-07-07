public class PrimitiveToStringDemo {
    public static void main(String[] args) {
        int intValue = 123;
        double doubleValue = 123.45;
        boolean booleanValue = true;

        // 转换成字符串
        String intStr = String.valueOf(intValue);
        String doubleStr = String.valueOf(doubleValue);
        String booleanStr = String.valueOf(booleanValue);

        System.out.println("int to String: " + intStr);
        System.out.println("double to String: " + doubleStr);
        System.out.println("boolean to String: " + booleanStr);

        // 也可以用包装类的toString方法
        String intStr2 = Integer.toString(intValue);
        String doubleStr2 = Double.toString(doubleValue);
        String booleanStr2 = Boolean.toString(booleanValue);

        System.out.println("int to String (using toString): " + intStr2);
        System.out.println("double to String (using toString): " + doubleStr2);
        System.out.println("boolean to String (using toString): " + booleanStr2);
    }
}
