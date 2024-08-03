### 自定义注解结合AOP在Spring Boot中的使用

#### 目录
1. 概述
2. 创建自定义注解
3. 创建AOP切面
4. 使用示例
5. 总结

---

### 1. 概述

在Spring Boot中，自定义注解结合AOP（面向切面编程）可以用于在方法执行前后添加额外的行为，比如日志记录、权限校验或字段自动填充。通过AOP，可以将这些横切关注点与业务逻辑分离，提高代码的可维护性。

### 2. 创建自定义注解

首先，我们创建一个自定义注解`AutoFill`，用于标记需要自动填充字段的方法。

```java
package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoFill {
    OperationType value();
}
```

这里，`OperationType`是一个枚举类，用于指示操作类型（插入或更新）：

```java
package com.sky.enumeration;

public enum OperationType {
    INSERT,
    UPDATE
}
```

### 3. 创建AOP切面

接下来，我们创建一个AOP切面类`AutoFillAspect`，在方法执行前自动填充字段。

```java
package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointCut() {
    }

    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("开始进行公共字段填充");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        OperationType operationType = autoFill.value();
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];

        LocalDateTime now = LocalDateTime.now();
        Long currentId = BaseContext.getCurrentId();

        if (operationType == OperationType.INSERT) {
            try {
                Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                Method setCreateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);

                setCreateTime.invoke(entity, now);
                setCreateUser.invoke(entity, currentId);
                setUpdateTime.invoke(entity, now);
                setUpdateUser.invoke(entity, currentId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (operationType == OperationType.UPDATE) {
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);
                setUpdateTime.invoke(entity, now);
                setUpdateUser.invoke(entity, currentId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```

#### 代码解释

1. **方法签名获取和注解提取**：
    ```java
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
    OperationType operationType = autoFill.value();
    ```
   这里通过`JoinPoint`获取方法签名，并从签名中提取`AutoFill`注解及其值。

2. **参数获取和实体对象提取**：
    ```java
    Object[] args = joinPoint.getArgs();
    if (args == null || args.length == 0) {
        return;
    }
    Object entity = args[0];
    ```
   获取方法参数，并确保参数不为空，从中提取第一个参数作为实体对象。

3. **字段自动填充逻辑**：
   根据操作类型（插入或更新），使用反射调用实体对象的相应方法，填充创建时间、创建用户、更新时间和更新用户字段。

### 4. 使用示例

假设我们有一个实体类`User`，包含需要自动填充的字段及其对应的setter方法。

```java
package com.sky.entity;

import java.time.LocalDateTime;

public class User {
    private LocalDateTime createTime;
    private Long createUser;
    private LocalDateTime updateTime;
    private Long updateUser;

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}
```

在Mapper类的方法上使用`AutoFill`注解：

```java
package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.enumeration.OperationType;
import com.sky.entity.User;

public interface UserMapper {
    
    @AutoFill(OperationType.INSERT)
    void insertUser(User user);

    @AutoFill(OperationType.UPDATE)
    void updateUser(User user);
}
```

### 5. 总结

通过自定义注解结合AOP，我们可以轻松地实现一些公共逻辑的自动处理，如字段自动填充。这种方式不仅简化了代码，还提高了代码的可读性和可维护性。

---

这篇笔记涵盖了从创建自定义注解到AOP切面的详细步骤，并提供了一个实际使用的示例，希望对你理解和回顾自定义注解结合AOP在Spring Boot中的使用有所帮助。