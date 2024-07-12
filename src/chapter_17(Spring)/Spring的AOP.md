## AOP 笔记

### 1. 引入依赖

确保在 `pom.xml` 文件中引入了Spring AOP的依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

### 2. 创建切面类

定义一个切面类，实现你的切面逻辑。切面类通常包含切入点和通知（Advice）：

```java
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.myapp.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        // 执行方法前的日志记录逻辑
        System.out.println("Logging before method: " + joinPoint.getSignature().getName());
    }

    // 可以定义其他类型的通知，如 @After, @AfterReturning, @AfterThrowing, @Around 等
}
```

### 3. 使用场景

#### 3.1 日志记录

AOP可以用来在方法调用之前、之后或异常抛出时记录日志信息，这样可以避免在每个方法中都手动编写日志代码。

```java
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.myapp.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        // 执行方法前的日志记录逻辑
        System.out.println("Logging before method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.myapp.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        // 方法执行后的日志记录逻辑
        System.out.println("Logging after method: " + joinPoint.getSignature().getName() + " returns: " + result);
    }
}
```

#### 3.2 性能监控

AOP可以用来监控方法的执行时间，从而帮助分析和优化性能瓶颈。

```java
@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* com.example.myapp.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}
```

#### 3.3 事务管理

AOP与Spring的声明式事务管理结合，可以在方法调用时自动处理事务的开始、提交和回滚。

```java
@Service
public class MyService {

    @Transactional
    public void performTransactionalOperation() {
        // 业务逻辑
    }
}
```

#### 3.4 安全检查

AOP可以用来在方法调用之前进行权限检查，确保用户有权限执行某些操作。

```java
@Aspect
@Component
public class SecurityAspect {

    @Before("execution(* com.example.myapp.service.*.*(..)) && @annotation(com.example.myapp.annotation.Secured)")
    public void checkSecurity(JoinPoint joinPoint) {
        // 安全检查逻辑
        System.out.println("Security check before method: " + joinPoint.getSignature().getName());
    }
}
```

#### 3.5 缓存管理

AOP可以用来在方法调用之前或之后处理缓存，避免重复计算或数据库访问。

```java
@Aspect
@Component
public class CachingAspect {

    @Around("execution(* com.example.myapp.service.*.*(..))")
    public Object manageCache(ProceedingJoinPoint joinPoint) throws Throwable {
        // 缓存逻辑
        System.out.println("Cache management for method: " + joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }
}
```

#### 3.6 异常处理

AOP可以用来在方法抛出异常时进行统一的异常处理或日志记录。

```java
@Aspect
@Component
public class ExceptionHandlingAspect {

    @AfterThrowing(pointcut = "execution(* com.example.myapp.service.*.*(..))", throwing = "ex")
    public void handleException(JoinPoint joinPoint, Exception ex) {
        // 异常处理逻辑
        System.out.println("Exception in method: " + joinPoint.getSignature().getName() + " with message: " + ex.getMessage());
    }
}
```

### 4. AOP 底层原理

Spring AOP 的底层实现基于动态代理（JDK动态代理或CGLIB代理），具体取决于被代理的目标对象（是否实现了接口）：

- **JDK 动态代理：** 基于接口的代理，使用 `java.lang.reflect.Proxy` 类实现。
- **CGLIB 代理：** 针对类的代理，通过继承目标类生成子类，并覆盖其中的方法实现。

Spring AOP 在运行时动态地创建代理对象，将切面逻辑织入到目标方法的执行流程中。切面类通过 `@Aspect` 和相关的切入点表达式（Pointcut Expression）指定在何时、何地执行通知。通知类型包括前置通知（Before）、后置通知（AfterReturning）、环绕通知（Around）、异常通知（AfterThrowing）等，根据业务需求选择适当的通知类型。

### 5. 关键概念

当谈论AOP（面向切面编程）时，涉及到几个关键概念：通知类型、切入点表达式、连接点、切面和代理对象。

#### 5.1 通知类型（Advice Types）

在AOP中，通知类型定义了切面在何时执行其逻辑。Spring AOP支持以下几种通知类型：

- **Before（前置通知）：** 在方法调用前执行，适合做一些预处理操作，如日志记录、权限检查等。

- **AfterReturning（后置通知）：** 在方法正常返回后执行，可以访问方法的返回值，常用于日志记录等。

- **AfterThrowing（异常通知）：** 在方法抛出异常后执行，可以用来处理异常情况。

- **After（最终通知）：** 在方法调用后无论是否发生异常都执行，类似于finally块的行为。

- **Around（环绕通知）：** 环绕通知是最强大的通知类型，能完全控制目标方法的执行。它需要负责调用目标方法、处理异常以及执行其他通知逻辑。

#### 通知的执行顺序

Spring AOP中，通知的执行顺序如下：

1. **Before（前置通知）**：在目标方法执行之前调用。
2. **Around（环绕通知）**：在目标方法执行之前和之后调用。环绕通知需要显式地调用 `ProceedingJoinPoint` 的 `proceed()` 方法来执行目标方法。
3. **AfterReturning（后置通知）**：在目标方法成功返回之后调用。
4. **AfterThrowing（异常通知）**：在目标方法抛出异常之后调用。
5. **After（最终通知）**：在目标方法执行结束之后调用，无论方法是正常返回还是抛出异常。

这种顺序确保了在方法执行的各个阶段都有适当的通知处理逻辑。

#### 5.2 切入点表达式（Pointcut Expressions）

切入点表达式定义了在哪些连接点上应用通知。它允许你指定应该拦截的方法，可以通过方法签名、类名、包名等方式进行精确匹配或模糊匹配。

##### execution 表达式

`execution` 表达式用于匹配方法的执行。它的语法结构为 `execution(<修饰符模式>? <返回类型模式> <方法名模式>(<参数模式>) <异常模式>?)`。以下是几个例子：

- `execution(* com.example.myapp.service.*.*(..))`：匹配 `com.example.myapp.service` 包下所有类的所有方法。
- `execution(public * *(..))`：匹配所有公共方法。
- `execution(* set*(..))`：匹配所有以 `set` 开头的方法。

##### @Pointcut注解的使用

`@Pointcut` 注解用于定义一个切入点表达式。它标记一个空方法，这个方法的名字即为切入点的标识符。通过这种方式，你可以在通知中引用这个切入点，而不必重复写切入点表达式。

```java
@Aspect
public class LoggingAspect {

    // 定义一个切入点，拦截 com.example.service 包下所有类的所有方法
    @Pointcut("execution(* com.example.service.*.*(..))")
    public void serviceMethods() {}

    // 在执行 serviceMethods() 切入点前执行该通知
    @Before("serviceMethods()")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        System.out.println("Executing method: " + joinPoint.getSignature().getName());
        // 其他日志逻辑
    }
}
```

在这个示例中：

- `@Pointcut("execution(* com.example.service.*.*(..))")` 定义了一个切入点，拦截 `com.example.service` 包下所有类的所有方法。
- `public void serviceMethods() {}` 是一个空方法，用来作为切入点的标识符。
- `@Before("serviceMethods()")` 定义了一个前置通知，指定在执行 `serviceMethods()` 切入点之前执行这个通知。

通过使用 `@Pointcut` 注解，我们可以复用切入点表达式，提高代码的可读性和可维护性。

##### annotation 表达式

`annotation` 表达式用于匹配带有特定注解的方法。它的语法结构为 `@annotation(<注解类型>)`。以下是一个例子：

- `@annotation(org.springframework.transaction.annotation.Transactional)`：匹配带有 `@Transactional` 注解的方法。

```java
@Aspect
public class TransactionAspect {

    // 定义一个切入点，拦截所有带有 @Transactional 注解的方法
    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void transactionalMethods() {}

    // 在执行 transactionalMethods() 切入点前执行该通知
    @Before("transactionalMethods()")
    public void logBeforeTransactionalMethod(JoinPoint joinPoint) {
        System.out.println("Executing transactional method: " + joinPoint.getSignature().getName());
        // 其他日志逻辑
    }
}
```

在这个示例中：

- `@Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")` 定义了一个切入点，拦截所有带有 `@Transactional` 注解的方法。
- `public void transactionalMethods() {}` 是一个空方法，用来作为切入点的标识符。
- `@Before("transactionalMethods()")` 定义了一个前置通知，指定在执行 `transactionalMethods()` 切入点之前执行这个通知。

#### 5.3 连接点（Joinpoints）

连接点是在应用执行过程中能够应用通知的点，它们通常是方法调用或异常抛出的地方。在Spring AOP中，连接点是指那些可以被拦截并应用通知的方法调用。每个方法调用都是一个潜在的连接点。

##### JoinPoint

`JoinPoint` 接口提供了对当前连接点处的状态和上下文信息的访问。通过 `JoinPoint` 对象，可以获取如下信息：

- **目标方法的签名（Signature）**：使用 `getSignature()` 方法获取 `Signature` 对象，该对象包含方法的详细信息，如方法名、返回类型、参数类型等。
- **目标方法的参数（Arguments）**：使用 `getArgs()` 方法获取方法的参数列表。
- **目标对象（Target Object）**：使用 `getTarget()` 方法获取目标对象（即被通知方法所属的对象）。
- **代理对象（Proxy Object）**：使用 `getThis()` 方法获取当前的代理对象。

以下是一个使用 `JoinPoint` 的例子：

```java
@Aspect
public class LoggingAspect {

    // 在执行 serviceMethods() 切入点前执行该通知
    @Before("execution(* com.example.service.*.*(..))")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        System.out.println("Executing method: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Target Object: " + joinPoint.getTarget());
        System.out.println("Proxy Object: " + joinPoint.getThis());
        // 其他日志逻辑
    }
}
```

##### ProceedingJoinPoint

`ProceedingJoinPoint` 是 `JoinPoint` 的一个子接口，只能在环绕通知中使用。它提供了一个 `proceed()` 方法，用于控制目标方法的执行。通过调用 `proceed()` 方法，可以继续执行目标方法，也可以完全改变方法的执行过程。

#### 5.4 切面（Aspect）

切面是一个类，它包含通知和切入点的定义。通常用 `@Aspect` 注解来标识一个类为切面，其中包含多个方法用来定义不同类型的通知。

#### 5.5 代理对象（Proxy Objects）

Spring AOP通过代理对象来实现切面的功能。当目标对象被拦截时，Spring创建一个代理对象，该代理对象包含切面定义的通知逻辑。代理对象可以是基于JDK动态代理（基于接口的代理）或CGLIB代理（基于类的代理）。

这些概念共同构成了AOP的核心理念，帮助开发者更加灵活地管理和增强应用程序的行为。