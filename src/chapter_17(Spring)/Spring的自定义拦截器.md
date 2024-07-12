# Spring 拦截器笔记

## 一、拦截器的基本概念

拦截器（Interceptor）是 Spring MVC 提供的一种用于对请求进行预处理和后处理的机制。通过拦截器，可以在请求到达控制器之前和响应返回客户端之前进行处理。

## 二、拦截器的底层原理

Spring 拦截器基于 Java Servlet 过滤器机制。拦截器的工作流程如下：

1. **请求到达 DispatcherServlet：** Spring MVC 的核心是 `DispatcherServlet`，所有的请求都会经过它。
2. **HandlerMapping 确定处理器：** `DispatcherServlet` 通过 `HandlerMapping` 确定要使用哪个处理器（Controller）来处理请求。
3. **调用拦截器链：** 在处理器执行之前，`DispatcherServlet` 会依次调用配置的拦截器的 `preHandle` 方法。如果任一拦截器的 `preHandle` 方法返回 `false`，则请求处理链终止。
4. **执行处理器：** 如果所有拦截器的 `preHandle` 方法都返回 `true`，则执行处理器的逻辑。
5. **调用拦截器链的 `postHandle` 方法：** 在处理器执行完成后，`DispatcherServlet` 会依次调用拦截器的 `postHandle` 方法。
6. **生成视图：** `DispatcherServlet` 生成视图。
7. **调用拦截器链的 `afterCompletion` 方法：** 最后，在整个请求完成后（包括视图渲染后），`DispatcherServlet` 会调用拦截器的 `afterCompletion` 方法进行清理工作。

## 三、路径填写规则

拦截器可以通过路径模式来指定要拦截哪些请求。常见的路径匹配规则如下：

- `/path/*`：匹配 `/path` 下的所有子路径。
- `/path/**`：匹配 `/path` 及其所有子路径，包括多级子路径。
- `/path/*.do`：匹配 `/path` 下的所有以 `.do` 结尾的请求。

## 四、如何使用拦截器

### 1. 创建拦截器类

拦截器需要实现 `HandlerInterceptor` 接口，通常需要重写 `preHandle`、`postHandle` 和 `afterCompletion` 三个方法。

```java
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在处理器执行之前执行
        System.out.println("Pre Handle method is Calling");
        return true; // 返回true继续处理，返回false中止请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在处理器执行之后，视图渲染之前执行
        System.out.println("Post Handle method is Calling");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在整个请求完成之后执行
        System.out.println("Request and Response is completed");
    }
}
```

### 2. 配置拦截器

在 Spring 配置文件或配置类中注册拦截器。

**XML 配置：**

```xml
<mvc:interceptors>
    <mvc:interceptor>
        <mvc:mapping path="/path/**"/>
        <bean class="com.example.MyInterceptor"/>
    </mvc:interceptor>
</mvc:interceptors>
```

**Java 配置：**

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/path/**");
    }
}
```

### 3. 示例代码

假设有一个简单的 Spring Boot 项目，项目结构如下：

```
src
└── main
    ├── java
    │   └── com.example.demo
    │       ├── DemoApplication.java
    │       ├── WebConfig.java
    │       ├── MyInterceptor.java
    │       └── HelloController.java
    └── resources
        └── application.properties
```

**DemoApplication.java：**

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

**WebConfig.java：**

```java
package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/hello/**");
    }
}
```

**MyInterceptor.java：**

```java
package com.example.demo;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Handle method is Calling");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle method is Calling");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Request and Response is completed");
    }
}
```

**HelloController.java：**

```java
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

### 4. 启动项目

运行 `DemoApplication` 类，启动 Spring Boot 项目。在浏览器中访问 `http://localhost:8080/hello`，可以在控制台中看到拦截器方法的输出。

## 五、总结

通过上述步骤，您可以在 Spring MVC 项目中成功地使用拦截器。拦截器在处理请求的各个阶段提供了灵活的钩子，使您能够实现各种预处理和后处理逻辑，是构建健壮的 Spring 应用程序的重要工具。