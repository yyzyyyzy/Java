package JUnit框架实现;

import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// 定义注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface SimpleJUnitTest {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface SimpleJUnitBefore {
}

// 测试框架
public class SimpleJUnitDemo {
    // 示例测试类
    public static void main(String[] args) {
        runTests(SimpleJUnitDemoTest.class);
    }

    public static void runTests(Class<?> testClass) {
        Method beforeMethod = null;

        // 找到带有 @Before 注解的方法
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(SimpleJUnitBefore.class)) {
                beforeMethod = method;
                break;
            }
        }

        // 找到带有 @Test 注解的方法并运行它们
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(SimpleJUnitTest.class)) {
                try {
                    Object testInstance = testClass.getDeclaredConstructor().newInstance();

                    if (beforeMethod != null) {
                        beforeMethod.invoke(testInstance);
                    }

                    method.invoke(testInstance);
                    System.out.println("Test " + method.getName() + " passed.");
                } catch (Exception e) {
                    System.out.println("Test " + method.getName() + " failed: " + e.getCause());
                }
            }
        }
    }
}

class SimpleJUnitDemoTest {
    @SimpleJUnitBefore
    public void setUp() {
        System.out.println("Setting up before test...");
    }

    @SimpleJUnitTest
    public void test1() {
        System.out.println("Running test1");
        assert true;
    }

    @SimpleJUnitTest
    public void test2() {
        System.out.println("Running test2");
        assert false : "test2 failed";
    }

    @SimpleJUnitTest
    public void test3() {
        System.out.println("Running test3");
        assert 1 + 1 == 2 : "test3 failed";
    }
}
