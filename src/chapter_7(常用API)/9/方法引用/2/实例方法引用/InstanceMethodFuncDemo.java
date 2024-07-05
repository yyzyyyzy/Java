// 定义一个函数式接口，接受两个整数参数并返回整数结果
interface InstanceMethodOperation {
    int operate(int a, int b);
}

class InstanceMethodFunc {
    // 一个简单的实例方法，计算两个整数的乘积
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class InstanceMethodFuncDemo {
    public static void main(String[] args) {
        InstanceMethodFunc instanceMethodFunc = new InstanceMethodFunc();

        // 使用匿名内部类实现接口改写方法
        InstanceMethodOperation operation1 = new InstanceMethodOperation() {
            @Override
            public int operate(int a, int b) {
                //静态方法与类直接相关联，因此可以直接通过类名调用，而实例方法是依赖于对象的，必须通过对象实例来调用。
                return instanceMethodFunc.multiply(a, b);
            }
        };

        // 使用Lambda表达式定义函数式接口的实例
        InstanceMethodOperation operation2 = (a, b) -> instanceMethodFunc.multiply(a, b);

        // 使用实例方法引用进一步简化lambda表达式
        InstanceMethodOperation operation3 = instanceMethodFunc::multiply;

        int result1 = operation1.operate(5, 3);
        int result2 = operation2.operate(5, 3);
        int result3 = operation3.operate(5, 3);
        System.out.println("Result: " + result1); // 输出: Result: 15
        System.out.println("Result: " + result2); // 输出: Result: 15
        System.out.println("Result: " + result3); // 输出: Result: 15
    }
}