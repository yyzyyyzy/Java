public class ForDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello lzk");
        }


        //增强 for 循环——for(声明语句:表达式)
        //声明语句：声明新的局部变量，该变量的类型必须和数组元素的类型匹配。其作用域限定在循环语句块，其值与此时数组元素的值相等。
        //表达式：表达式是要访问的数组名，或者是返回值为数组的方法。
        int[] numbers = {10, 20, 30, 40, 50};
        for (int x : numbers) {
            System.out.println(x);
        }

        //无限 for 循环——for(;;)
        for (; ; ) {
            System.out.println("hello lzk");
        }
    }
}