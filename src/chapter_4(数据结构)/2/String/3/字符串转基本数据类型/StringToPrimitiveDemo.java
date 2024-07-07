public class StringToPrimitiveDemo {
    public static void main(String[] args) {
        String strInt = "123";
        String strDouble = "123.45";
        String strBoolean = "true";

        // 转换成int
        int intValue = Integer.parseInt(strInt);
        System.out.println("String to int: " + intValue);

        // 转换成double
        double doubleValue = Double.parseDouble(strDouble);
        System.out.println("String to double: " + doubleValue);

        // 转换成boolean
        boolean booleanValue = Boolean.parseBoolean(strBoolean);
        System.out.println("String to boolean: " + booleanValue);
    }
}
