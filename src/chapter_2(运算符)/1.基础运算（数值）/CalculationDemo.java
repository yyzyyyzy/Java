package 运算符;

public class CalculationDemo {
    public static void main(String[] args) {
        System.out.println(1 + 1); //加
        System.out.println(2 - 1); //减
        System.out.println(3 * 2); //乘
        System.out.println(4 / 2); //除
        System.out.println(4 % 2); //取模、取余

        //小数参与计算会出现精度的问题
        System.out.println(1.1 + 2.2);
        System.out.println(1.1 + 2.02);

        //自增自减运算符
        int a = 1;
        a++;
        a--;
        System.out.println(a);

        //赋值运算符
        int b = 1;
        b += 1;
        b -= 1;
        b *= 1;
        b /= 1;
        b %= 1;
        System.out.println(b);

        //关系运算符
        int c = 3;
        int d = 4;
        boolean result1 = c == d;
        boolean result2 = c != d;
        boolean result3 = c >= d;
        boolean result4 = c <= d;
        boolean result5 = c > d;
        boolean result6 = c < d;
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);

        //逻辑运算符
        //左边无论是true还是false，右边的表达式都会参与最终判断
        System.out.println(true & true); //与
        System.out.println(true | true); //或
        System.out.println(!true);       //非
        System.out.println(true ^ true); //异或（相同为true，不同为false）

        //短路逻辑运算符
        System.out.println(true && true); //与
        System.out.println(true || true); //或
        //当左边的表达式可以确定最终的结果，右边的表达式就不会参与最终判断了
        boolean ret = false && ++b > 8;

        //三元表达式
        int e, f;
        e = 10;
        // 如果 e 等于 1 成立，则设置 f 为 20，否则为 30
        f = (e == 1) ? 20 : 30;
        System.out.println("Value of b is : " + f);

        // 如果 e 等于 10 成立，则设置 f 为 20，否则为 30
        f = (e == 10) ? 20 : 30;
        System.out.println("Value of b is : " + f);


        //原码反码补码
        //原码：最左边是符号位，0为正，1为负
        //反码：正数的反码不变，负数的反码在原码基础上，符号位不变，数值取反，0变1，1变0
        //补码：正数的补码不变，负数的补码在反码的基础上+1

        //instanceof 运算符
        //如果运算符左侧变量所指的对象，是操作符右侧类或接口(class/interface)的一个对象，那么结果为真。
        String name = "James";
        boolean isString = name instanceof String;
        System.out.println(isString);
    }
}
