import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("123.45");
        BigDecimal bd2 = BigDecimal.valueOf(123.45); // 推荐使用
        BigDecimal bd3 = new BigDecimal(123.45); // 不推荐，可能会有精度问题

        System.out.println("bd1: " + bd1);
        System.out.println("bd2: " + bd2);
        System.out.println("bd3: " + bd3);

        //加减乘除
        BigDecimal bd4 = new BigDecimal("123.45");
        BigDecimal bd5 = new BigDecimal("54.55");
        //1.加法运算
        BigDecimal sum = bd4.add(bd5);
        System.out.println("Sum: " + sum); // 输出：Sum: 178.00

        //2.减法运算
        BigDecimal difference = bd4.subtract(bd5);
        System.out.println("Difference: " + difference); // 输出：Difference: 68.90

        //3.乘法运算
        BigDecimal product = bd4.multiply(bd5);
        System.out.println("Product: " + product); // 输出：Product: 246.90

        //4.除法运算
        /*
        BigDecimal.ROUND_UP: 向远离零的方向舍入（向正无穷大方向舍入）。
        BigDecimal.ROUND_DOWN: 向接近零的方向舍入（向负无穷大方向舍入）。
        BigDecimal.ROUND_CEILING: 向正无穷大方向舍入，不管是正数还是负数。
        BigDecimal.ROUND_FLOOR: 向负无穷大方向舍入，不管是正数还是负数。
        BigDecimal.ROUND_HALF_UP: 四舍五入，当一个数字刚好在两个数值的中间时，向上舍入。
        BigDecimal.ROUND_HALF_DOWN: 四舍五入，当一个数字刚好在两个数值的中间时，向下舍入。
        BigDecimal.ROUND_HALF_EVEN: 四舍五入，当一个数字刚好在两个数值的中间时，向最接近的偶数舍入。
        BigDecimal.ROUND_UNNECESSARY: 如果舍入结果是精确的，不需要舍入，否则抛出 ArithmeticException 异常。
         */
        BigDecimal quotient = bd4.divide(bd5, 2, BigDecimal.ROUND_HALF_UP); // 保留2位小数，四舍五入
        System.out.println("Quotient: " + quotient); // 输出：Quotient: 61.73

        //5.比较大小
        int result = bd4.compareTo(bd5);
        if (result == 0) {
            System.out.println("bd1 和 bd2 相等");
        } else if (result > 0) {
            System.out.println("bd1 大于 bd2");
        } else {
            System.out.println("bd1 小于 bd2");
        }
    }
}