### Lombok 使用指南

---

#### 1. 简介

Lombok 是一个用于减少 Java 样板代码的库。通过使用一组注解，Lombok 可以自动生成常见的代码如 getter、setter、toString、equals 和 hashCode 方法等，从而提高开发效率和代码可读性。

---

#### 2. Lombok 依赖

在使用 Lombok 之前，需要在项目的 `pom.xml` 文件中添加 Lombok 依赖：

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.28</version> <!-- 请使用最新版本 -->
    <scope>provided</scope>
</dependency>
```

---

#### 3. 常用注解

**@Getter** 和 **@Setter**:
- 自动生成 getter 和 setter 方法。

```java
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Example {
    private String name;
    private int age;
}
```

**@Data**:
- 包含 `@Getter`、`@Setter`、`@ToString`、`@EqualsAndHashCode` 和 `@RequiredArgsConstructor` 注解的组合。

```java
import lombok.Data;

@Data
public class Example {
    private String name;
    private int age;
}
```

**@ToString**:
- 自动生成 `toString` 方法。

```java
import lombok.ToString;

@ToString
public class Example {
    private String name;
    private int age;
}
```

**@EqualsAndHashCode**:
- 自动生成 `equals` 和 `hashCode` 方法。

```java
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Example {
    private String name;
    private int age;
}
```

**@NoArgsConstructor** 和 **@AllArgsConstructor**:
- 自动生成无参构造函数和全参构造函数。

```java
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Example {
    private String name;
    private int age;
}
```

**@Builder**:
- 提供流式 API 构建对象。

```java
import lombok.Builder;

@Builder
public class Example {
    private String name;
    private int age;
}

// 使用
Example example = Example.builder()
                         .name("John")
                         .age(30)
                         .build();
```

---

#### 4. 示例

##### 4.1. 简单类的 Lombok 优化

原始类：

```java
public class Person {
    private String name;
    private int age;

    // Getters and Setters
}
```

使用 Lombok 优化后：

```java
import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;
}
```

##### 4.2. 带有构造函数的类

原始类：

```java
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Getters and Setters
}
```

使用 Lombok 优化后：

```java
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
}
```

##### 4.3. 带有复杂字段的类

原始类：

```java
import java.util.List;

public class Employee {
    private String name;
    private int age;
    private Address address;
    private List<String> skills;

    // Getters and Setters
}
```

使用 Lombok 优化后：

```java
import lombok.Data;
import java.util.List;

@Data
public class Employee {
    private String name;
    private int age;
    private Address address;
    private List<String> skills;
}
```

---

#### 5. IDE 配置

##### IntelliJ IDEA

1. 安装 Lombok 插件：File -> Settings -> Plugins -> 搜索 “Lombok” 并安装。
2. 启用注解处理器：File -> Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors，勾选 "Enable annotation processing"。

##### Eclipse

1. 安装 Lombok 插件：Help -> Eclipse Marketplace -> 搜索 “Lombok” 并安装。
2. 配置注解处理器：Window -> Preferences -> Java -> Compiler -> Annotation Processing -> Factory Path，勾选 Lombok。

---

#### 6. 小结

Lombok 是一个强大的工具，可以显著减少 Java 代码中的样板代码，使代码更简洁和易于维护。通过熟练使用 Lombok 的各种注解，可以提高开发效率和代码质量。