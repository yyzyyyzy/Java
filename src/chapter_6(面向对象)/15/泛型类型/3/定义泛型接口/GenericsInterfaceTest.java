package 定义泛型接口;

public class GenericsInterfaceTest {
    public static void main(String[] args) {
        定义泛型接口.MyGenericClass<Integer> integerGeneric = new 定义泛型接口.MyGenericClass<>();
        integerGeneric.setData(123);
        System.out.println("Integer data: " + integerGeneric.getData());

        定义泛型接口.MyGenericClass<String> stringGeneric = new 定义泛型接口.MyGenericClass<>();
        stringGeneric.setData("Hello, Generics!");
        System.out.println("String data: " + stringGeneric.getData());
    }
}