import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
Java动态代理主要用于以下场景：

    日志记录：
        在方法调用前后记录日志，可以了解方法的调用情况、传递的参数和返回值等信息。

    权限控制：
        在方法调用前检查权限，确保只有具有相应权限的用户才能调用某些方法。

    性能监控：
        监控方法的执行时间，以优化性能或检测性能瓶颈。

    事务管理：
        在方法调用前开启事务，方法调用后提交或回滚事务。这在数据库操作中非常常见。

    远程方法调用（RMI）：
        通过动态代理，客户端可以调用服务器上的方法，而不需要了解具体的网络通信细节。

    AOP（面向切面编程）：
        动态代理是实现AOP的重要手段之一，可以在不修改源代码的情况下，向程序中添加新的功能。

    缓存机制：
        在方法调用前检查缓存，如果缓存中已有结果则直接返回，否则执行方法并将结果存入缓存。

通过动态代理，开发者可以在不修改目标对象代码的情况下，灵活地为对象添加各种横切关注点（如日志、事务、权限控制等）。
这是实现AOP（面向切面编程）的基础之一
 */


// 定义接口，代理类将实现这个接口
interface DProxy {
    void sayHello();
}

// 实现接口的具体类，即目标对象
class DProxyImpl implements DProxy {
    @Override
    public void sayHello() {
        System.out.println("Hello, world!");
    }
}

// 定义InvocationHandler，用于处理代理实例上的方法调用
class DProxyInvocationHandler implements InvocationHandler {
    private final Object target;

    // 构造方法，接收一个目标对象
    public DProxyInvocationHandler(Object target) {
        this.target = target;
    }

    // 处理代理实例上的方法调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法调用前执行
        System.out.println("Before method: " + method.getName());
        // 调用目标对象的方法
        Object result = method.invoke(target, args);
        // 方法调用后执行
        System.out.println("After method: " + method.getName());
        return result;
    }
}

public class DynamicProxyDemo {
    public static void main(String[] args) {
        // 创建目标对象，即被代理的对象
        DProxy hello = new DProxyImpl();

        // 创建InvocationHandler实例，传入目标对象
        InvocationHandler handler = new DProxyInvocationHandler(hello);

        // 创建动态代理对象
        // 第一个参数是类加载器，用于加载代理类
        // 第二个参数是接口数组，代理类需要实现这些接口
        // 第三个参数是InvocationHandler实例，用于处理方法调用
        DProxy proxy = (DProxy) Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                handler
        );

        // 调用方法，通过代理对象调用目标对象的方法
        proxy.sayHello();
    }
}
