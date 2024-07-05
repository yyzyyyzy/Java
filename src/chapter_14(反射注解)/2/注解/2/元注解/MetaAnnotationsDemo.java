package 元注解;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// 1. @Retention
//RetentionPolicy.SOURCE：注解仅在源代码中保留，编译时被丢弃。
//RetentionPolicy.CLASS：注解在编译时被保留，但在运行时不被加载到 JVM 中。
//RetentionPolicy.RUNTIME：注解在运行时也被保留，可以通过反射读取。
@Retention(RetentionPolicy.RUNTIME)

// 2. @Target
//ElementType.TYPE：类、接口（包括注解类型）或枚举声明。
//ElementType.FIELD：字段声明（包括枚举常量）。
//ElementType.METHOD：方法声明。
@Target({ElementType.TYPE, ElementType.METHOD})

// 3. @Inherited
//@Inherited 指示注解类型是可继承的。
//如果一个注解类型被 @Inherited 标注，那么如果它被用在一个类上，这个注解将会被用在这个类的子类上
@Inherited

// 4. @Documented
//@Documented 指示使用这个注解的元素应该被 javadoc 或类似的工具文档化。这意味着它会在生成的文档中包含注解信息。
@Documented

// 5. @Repeatable
//@Repeatable 允许同一个注解在同一个声明上使用多次。Java 8 引入了这个元注解，需要定义一个容器注解。
@Repeatable(MyAnnotations.class)
@interface MyAnnotation {
    String value();
}

// 容器注解用于 @Repeatable
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@Documented
@interface MyAnnotations {
    MyAnnotation[] value();
}

// 使用自定义注解的基类
@MyAnnotation("ClassLevel")
class BaseClass {

    @MyAnnotation("MethodLevel1")
    @MyAnnotation("MethodLevel2")
    public void myMethod() {
    }
}

// 派生类继承了基类的注解
class DerivedClass extends BaseClass {
}

public class MetaAnnotationsDemo {
    public static void main(String[] args) {
        // 检查类级别的注解
        if (DerivedClass.class.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = DerivedClass.class.getAnnotation(MyAnnotation.class);
            System.out.println("Class Level Annotation: " + annotation.value());
        }

        // 检查方法级别的注解
        try {
            Method method = DerivedClass.class.getMethod("myMethod");
            // isAnnotationPresent 用于检查指定的注解类型是否存在于元素上（例如类、方法、字段等）
            if (method.isAnnotationPresent(MyAnnotations.class)) {
                // getAnnotation 用于获取指定类型的注解实例。如果注解存在，它返回该注解实例；如果注解不存在，则返回 null
                MyAnnotations annotations = method.getAnnotation(MyAnnotations.class);
                for (MyAnnotation annotation : annotations.value()) {
                    System.out.println("Method Level Annotation: " + annotation.value());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
