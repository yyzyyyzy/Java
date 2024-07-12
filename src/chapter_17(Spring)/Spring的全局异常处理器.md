# Spring 全局异常处理器使用方法及底层原理

## 1. 简介
Spring 提供了一套异常处理机制，可以方便地处理应用程序中的异常。通过使用全局异常处理器，可以捕获所有未被处理的异常，并统一进行处理，从而提高代码的整洁性和可维护性。

## 2. 使用方法

### 2.1 使用 `@ControllerAdvice` 注解
`@ControllerAdvice` 注解用于定义全局异常处理类。该注解标识的类将应用于所有使用 `@RequestMapping` 注解的方法。

### 2.2 定义异常处理方法
在全局异常处理类中，通过 `@ExceptionHandler` 注解来定义具体的异常处理方法。方法的参数为要处理的异常类型，返回值可以是视图名、响应实体等。

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 处理特定异常
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // 处理所有其他异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

### 2.3 使用 `@ResponseStatus` 注解
`@ResponseStatus` 注解可以直接应用于异常类或异常处理方法，用于指定当该异常被抛出时返回的 HTTP 状态码。

```java
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
```

### 2.4 处理 `ResponseEntityExceptionHandler`
`ResponseEntityExceptionHandler` 是一个提供了许多默认异常处理方法的基类，可以通过继承该类并覆盖其方法来自定义异常处理。

```java
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = "Invalid arguments: " + ex.getBindingResult().toString();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
```

## 3. 底层原理

### 3.1 异常处理流程
Spring 的异常处理流程主要通过以下步骤进行：

1. **捕获异常**：在 `DispatcherServlet` 中捕获未处理的异常。
2. **处理异常**：根据捕获的异常类型，查找对应的 `@ExceptionHandler` 方法或默认的异常处理方法。
3. **返回响应**：将处理后的结果（如自定义的错误信息和状态码）返回给客户端。

### 3.2 `@ControllerAdvice` 的实现
`@ControllerAdvice` 的核心实现是通过 Spring 的 AOP（面向切面编程）机制，将标注了 `@ControllerAdvice` 的类注册为全局异常处理器，并拦截所有控制器方法的异常。

### 3.3 `@ExceptionHandler` 的匹配机制
`@ExceptionHandler` 注解的方法会被 Spring 自动扫描并注册。当异常发生时，Spring 会根据异常类型进行匹配，找到对应的处理方法。

### 3.4 优先级
Spring 在匹配异常处理方法时会按照以下优先级进行：
1. 方法级别的 `@ExceptionHandler`。
2. 类级别的 `@ExceptionHandler`。
3. 全局 `@ControllerAdvice` 的 `@ExceptionHandler`。

### 3.5 继承与覆盖
通过继承 `ResponseEntityExceptionHandler` 并覆盖其方法，可以使用框架内置的异常处理逻辑，同时进行自定义处理。

## 4. 参考资料

- [Spring 官方文档 - 异常处理](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-exceptionhandler)
- [Spring Boot 官方文档 - 错误处理](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-error-handling)

通过以上方法，可以在 Spring 应用中实现统一的异常处理，提高代码的健壮性和可维护性。