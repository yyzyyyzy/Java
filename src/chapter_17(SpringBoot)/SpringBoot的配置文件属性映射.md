## `@ConfigurationProperties(prefix = "")` 注解详解

### 概述
`@ConfigurationProperties` 是 Spring 框架中的一个注解，用于将属性文件（例如 application.properties 或 application.yml）中的配置映射到 Java 类中。这个注解的 `prefix` 属性允许我们指定一个前缀，用于筛选配置文件中的属性。

### 功能
- **属性映射**：将配置文件中的属性值映射到 Java 对象的字段中。
- **类型安全**：通过使用强类型的 Java 类来表示配置，提供类型安全的配置管理。
- **支持复杂类型**：支持将属性映射到嵌套的 Java 对象或集合类型。

### 使用方法
#### 步骤一：引入依赖
确保在项目的 `pom.xml` 文件中引入了 Spring Boot 的相关依赖。
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

#### 步骤二：定义属性类
定义一个 Java 类，用于映射配置文件中的属性。使用 `@ConfigurationProperties` 注解指定属性的前缀。
```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String name;
    private String description;
    private Security security = new Security();

    // getters and setters

    public static class Security {
        private String username;
        private String password;

        // getters and setters
    }
}
```

#### 步骤三：配置文件
在配置文件（如 `application.yml`）中定义对应的属性。
```yaml
app:
  name: MyApplication
  description: This is a sample application.
  security:
    username: admin
    password: secret
```

#### 步骤四：使用属性
在应用程序中，注入属性类并使用其中的属性。
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    private AppProperties appProperties;

    @GetMapping("/info")
    public String getAppInfo() {
        return "Name: " + appProperties.getName() + ", Description: " + appProperties.getDescription();
    }

    @GetMapping("/security")
    public String getSecurityInfo() {
        return "Username: " + appProperties.getSecurity().getUsername() + ", Password: " + appProperties.getSecurity().getPassword();
    }
}
```

### `prefix` 属性详解
`prefix` 属性用于指定配置文件中属性的前缀，便于将相关配置归类。举例说明：

#### 示例一：使用前缀
```java
@Component
@ConfigurationProperties(prefix = "server")
public class ServerProperties {
    private String address;
    private int port;

    // getters and setters
}
```

```yaml
server:
  address: localhost
  port: 8080
```

#### 示例二：不使用前缀
如果不使用前缀，可以省略 `prefix` 属性或将其设为空字符串。
```java
@Component
@ConfigurationProperties(prefix = "")
public class GlobalProperties {
    private String applicationName;
    private String version;

    // getters and setters
}
```

```yaml
applicationName: GlobalApp
version: 1.0.0
```

### 常见问题
- **未能映射属性**：确保属性名与配置文件中的键名完全匹配。
- **未注入属性类**：确保属性类使用了 `@Component` 注解，并在 Spring 上下文中注册。

### 总结
`@ConfigurationProperties(prefix = "")` 注解是一个强大的工具，用于将配置文件中的属性映射到 Java 对象中。通过使用 `prefix` 属性，可以轻松地组织和管理应用程序的配置，提高代码的可维护性和可读性。

---

### 复习要点
1. **定义属性类**：使用 `@ConfigurationProperties` 注解指定前缀。
2. **配置文件定义属性**：确保属性与类中的字段匹配。
3. **注入和使用属性**：通过 Spring 的依赖注入机制使用配置属性。
4. **前缀的作用**：组织和分类配置属性。

希望这些内容对你有所帮助，方便你进行复习和回顾。