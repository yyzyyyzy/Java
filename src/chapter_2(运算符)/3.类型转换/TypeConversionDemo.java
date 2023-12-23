public class TypeConversionDemo {
    public static void main(String[] args) {
        //从小到大：byte short int long float double
        //隐式转换：取值范围小的转换为取值范围大的
        byte a = 10;
        double b = a;
        System.out.println(b);

        //隐式转换规则：
        //取值范围小的，和取值范围大的进行运算，小的会先提升为大的，再进行运算
        //byte short char 三种类型在运算的时候，会直接提升为int，再进行运算
        int c = 10;
        double d = 123.1;
        System.out.println(c + d); //最终得到的是double类型

        //强制转换：取值范围大的转换为取值范围小的
        //取值范围大的数值是不允许赋值给取值范围小的变量的，如果一定要这么做，需要加上强制类型转换
        double e = 10;
        byte f = (byte) e;
        System.out.println(f);

        byte g = 10;
        byte h = 100;
        byte i = (byte) (g + h);
        System.out.println(i);
    }
}

