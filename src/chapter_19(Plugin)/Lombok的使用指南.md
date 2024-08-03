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

#### 4. 综合示例

考虑一个包含个人信息和地址的应用：

```java
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private Address address;

    public static void main(String[] args) {
        Address address = Address.builder()
                                .street("123 Main St")
                                .city("City")
                                .state("State")
                                .zip("12345")
                                .build();

        Person person = Person.builder()
                              .name("John Doe")
                              .age(30)
                              .address(address)
                              .build();

        System.out.println(person);
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
}
```

在这个例子中，使用了 `@Data`、`@Builder` 和 `@AllArgsConstructor` 注解：
- `@Data` 自动生成了所有字段的 `getter`、`setter`、`equals`、`hashCode` 和 `toString` 方法。
- `@Builder` 提供了流式 API 构建 `Person` 和 `Address` 对象。
- `@AllArgsConstructor` 自动生成了包含所有字段的全参构造函数。

---