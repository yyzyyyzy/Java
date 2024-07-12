# 过滤器（Filter）笔记

## 1. 过滤器的底层原理

### 1.1 过滤器概述
过滤器（Filter）是Java EE规范的一部分，它们用于拦截和处理HTTP请求和响应。过滤器可以在请求到达Servlet或JSP之前，或在响应发送到客户端之前，执行一些操作，如验证、日志记录、修改请求或响应内容等。

### 1.2 过滤器的工作流程
1. **客户端发送请求**：客户端发送HTTP请求到服务器。
2. **过滤器链**：请求首先通过过滤器链，每个过滤器都有机会处理请求。
3. **目标资源**：过滤器链处理完成后，请求到达目标Servlet或JSP。
4. **响应处理**：响应从目标资源返回，再次经过过滤器链，最后到达客户端。

### 1.3 过滤器的主要接口和方法
- `javax.servlet.Filter`接口：所有过滤器必须实现这个接口。
    - `void init(FilterConfig filterConfig)`: 在过滤器实例化后进行初始化。
    - `void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)`: 核心方法，用于处理请求和响应。
    - `void destroy()`: 在过滤器销毁前进行清理工作。

## 2. urlPatterns填写规则

### 2.1 概述
`urlPatterns`用于指定过滤器应用于哪些URL模式，可以在`web.xml`中配置，也可以使用注解。

### 2.2 常用规则
- 精确匹配：如`/myServlet`，仅匹配特定的URL。
- 路径匹配：如`/admin/*`，匹配指定路径下的所有资源。
- 扩展名匹配：如`*.jsp`，匹配所有指定扩展名的资源。
- 默认匹配：如`/`，匹配所有请求。

### 2.3 配置示例
**web.xml配置：**
```xml
<filter>
    <filter-name>MyFilter</filter-name>
    <filter-class>com.example.MyFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>MyFilter</filter-name>
    <url-pattern>/admin/*</url-pattern>
</filter-mapping>
```

**注解配置：**
```java
@WebFilter(filterName = "MyFilter", urlPatterns = {"/admin/*", "*.jsp"})
public class MyFilter implements Filter {
    // 实现方法
}
```

## 3. 过滤器的使用

### 3.1 创建过滤器
1. **实现Filter接口**：
   ```java
   import javax.servlet.*;
   import java.io.IOException;

   public class MyFilter implements Filter {
       @Override
       public void init(FilterConfig filterConfig) throws ServletException {
           // 初始化代码
       }

       @Override
       public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
               throws IOException, ServletException {
           // 前置处理
           System.out.println("Request received at MyFilter");

           // 继续链式调用
           chain.doFilter(request, response);

           // 后置处理
           System.out.println("Response leaving MyFilter");
       }

       @Override
       public void destroy() {
           // 销毁代码
       }
   }
   ```

2. **配置过滤器**（见上文`urlPatterns`配置示例）。

### 3.2 常见使用场景
- **认证和授权**：验证用户是否登录，检查用户权限。
- **日志记录**：记录请求和响应的详细信息。
- **修改请求和响应**：对请求参数或响应内容进行修改。
- **压缩响应**：对响应内容进行GZIP压缩。

### 3.3 示例
**认证过滤器示例**：
```java
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/secure/*"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}
}
```

## 4. 过滤器链

### 4.1 过滤器链概述
过滤器链（Filter Chain）是多个过滤器按特定顺序链接在一起，形成处理请求和响应的责任链。每个过滤器在完成自己的处理逻辑后，通过调用`FilterChain`的`doFilter`方法将请求和响应传递给链中的下一个过滤器，最终传递给目标资源（如Servlet）。

### 4.2 过滤器链的工作流程
1. **请求到达第一个过滤器**：过滤器链中的第一个过滤器接收到请求。
2. **依次调用链中的过滤器**：每个过滤器完成处理后调用`doFilter`方法，将请求传递给下一个过滤器。
3. **到达目标资源**：所有过滤器处理完成后，请求到达目标资源。
4. **响应通过过滤器链返回**：响应从目标资源返回，通过过滤器链依次处理，最后到达客户端。

### 4.3 过滤器链的配置
在`web.xml`中，过滤器链的顺序由`<filter-mapping>`元素的顺序决定。注解方式的顺序由服务器实现决定，通常按照类加载的顺序。

### 4.4 过滤器链示例
**web.xml配置多个过滤器**：
```xml
<filter>
    <filter-name>LoggingFilter</filter-name>
    <filter-class>com.example.LoggingFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>LoggingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>

<filter>
    <filter-name>AuthFilter</filter-name>
    <filter-class>com.example.AuthFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>AuthFilter</filter-name>
    <url-pattern>/secure/*</url-pattern>
</filter-mapping>
```

**过滤器实现**：
```java
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Request received at LoggingFilter");
        chain.doFilter(request, response);
        System.out.println("Response leaving LoggingFilter");
    }

    @Override
    public void destroy() {}
}

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/secure/*"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}
}
```

**说明**：
- `LoggingFilter`：负责记录请求和响应的信息。
- `AuthFilter`：负责检查用户是否登录。

在这个例子中，`LoggingFilter`会先于`AuthFilter`处理请求和响应。这样，通过配置多个过滤器，可以实现复杂的请求和响应处理逻辑。