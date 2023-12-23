public class FunctionOverloadingDemo {
    public static void main(String[] args) {

    }

    //方法名相同，方法的参数不同（个数不同，类型不同，顺序不同），与返回值无关
    //好处：可以不用相同的方法起很多不同的名字
    //举例如下：
    public static int getNum(int num1, int num2) {
        return 0;
    }

    public static double getNum(int num1, int num2, int num3) {
        return 0;
    }

    public static long getNum(int num1, int num2, int num3, int num4) {
        return 0;
    }
}