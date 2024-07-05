public class MathDemo {
    public static void main(String[] args) {
        //1. 获取参数绝对值
        int num1 = -10;
        int absNum = Math.abs(num1);
        System.out.println("绝对值：" + absNum); // 输出：绝对值：10

        //2. 向上取整
        double num2 = 3.14;
        double ceilNum = Math.ceil(num2);
        System.out.println("向上取整：" + ceilNum); // 输出：向上取整：4.0

        //3. 向下取整
        double num3 = 3.14;
        double floorNum = Math.floor(num3);
        System.out.println("向下取整：" + floorNum); // 输出：向下取整：3.0

        //4. 四舍五入
        double num4 = 3.56;
        long roundedNum = Math.round(num4);
        System.out.println("四舍五入：" + roundedNum); // 输出：四舍五入：4

        //5. 求最大值
        int num5 = 10;
        int num6 = 20;
        int maxNum = Math.max(num5, num6);
        System.out.println("最大值：" + maxNum); // 输出：最大值：20

        //6. 幂运算
        double base = 2.0;
        double exponent = 3.0;
        double result = Math.pow(base, exponent);
        System.out.println("幂运算：" + result); // 输出：幂运算：8.0

        //7. 生成随机数
        double randomNum = Math.random();
        System.out.println("随机数：" + randomNum); // 输出：随机数：(0.0 到 1.0 之间的随机数)
    }
}