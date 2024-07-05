// 定义一个函数式接口，接受两个整数参数并返回整数结果
interface StaticMethodOperation {
    int operate(int a, int b);
}

class StaticMethodFunc {
    // 一个简单的静态方法，计算两个整数的和
    public static int add(int a, int b) {
        return a + b;
    }
}

public class StaticMethodFuncDemo {
    public static void main(String[] args) {
        // 使用匿名内部类实现接口改写方法
        StaticMethodOperation operation1 = new StaticMethodOperation() {
            @Override
            public int operate(int a, int b) {
                //静态方法与类直接相关联，因此可以直接通过类名调用，而实例方法是依赖于对象的，必须通过对象实例来调用。
                return StaticMethodFunc.add(a, b);
            }
        };

        // 使用Lambda表达式定义函数式接口的实例
        StaticMethodOperation operation2 = (a, b) -> StaticMethodFunc.add(a, b);

        // 使用静态方法引用进一步简化lambda表达式
        StaticMethodOperation operation3 = StaticMethodFunc::add;

        int result1 = operation1.operate(5, 3);
        int result2 = operation2.operate(5, 3);
        int result3 = operation3.operate(5, 3);
        System.out.println("Result: " + result1); // 输出: Result: 8
        System.out.println("Result: " + result2); // 输出: Result: 8
        System.out.println("Result: " + result3); // 输出: Result: 8
    }
}


