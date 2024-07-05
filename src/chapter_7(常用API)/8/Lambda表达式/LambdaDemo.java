interface Lambda {
    void lambda();
}

public class LambdaDemo {
    public static void main(String[] args) {
        Lambda l1 = new Lambda() {
            @Override
            public void lambda() {
                System.out.println("重写只有一个抽象方法的函数式接口的时候可以用Lambda表达式简化");
            }
        };

        Lambda l2 = () -> System.out.println("重写只有一个抽象方法的函数式接口的时候可以用Lambda表达式简化");

        l1.lambda();
        l2.lambda();
    }
}