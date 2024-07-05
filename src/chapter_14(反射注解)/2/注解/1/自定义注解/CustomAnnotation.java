package 自定义注解;

import java.lang.reflect.Method;

//1. 定义自定义注解
//自定义注解使用 @interface 关键字定义。可以为注解添加属性（类似于接口中的方法），并为这些属性提供默认值。
@interface CustomAnnotationInterface {
    String value() default "default value";

    int number() default 0;
}

//2. 使用自定义注解
//在类、方法或字段上使用自定义注解。
class CustomAnnotationClass {
    @CustomAnnotationInterface(value = "Test Method", number = 1)
    public void testMethod() {
        System.out.println("This is a test method.");
    }
}

//3. 处理自定义注解
//可以使用反射来处理自定义注解，获取注解信息并执行相应的逻辑。
public class CustomAnnotation {
    public static void main(String[] args) {
        try {
            // 获取 TestClass 类
            Class<?> clazz = CustomAnnotationClass.class;

            // 获取类中的所有方法
            Method[] methods = clazz.getDeclaredMethods();

            // 遍历所有方法
            for (Method method : methods) {
                // 检查方法是否有 MyCustomAnnotation 注解
                if (method.isAnnotationPresent(CustomAnnotationInterface.class)) {
                    // 获取注解
                    CustomAnnotationInterface annotation = method.getAnnotation(CustomAnnotationInterface.class);

                    // 获取注解的属性值
                    String value = annotation.value();
                    int number = annotation.number();

                    // 打印注解信息
                    System.out.println("Method: " + method.getName());
                    System.out.println("MyCustomAnnotation value: " + value);
                    System.out.println("MyCustomAnnotation number: " + number);

                    // 调用带有注解的方法
                    method.invoke(clazz.getDeclaredConstructor().newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

