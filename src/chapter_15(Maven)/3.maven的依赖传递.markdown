## Maven 的依赖传递

### 什么是依赖传递？
依赖传递（Transitive Dependency）是 Maven 中的一项功能，它允许项目自动包含其依赖项所依赖的其他库。这意味着你只需在 `pom.xml` 文件中声明一次直接依赖，Maven 就会自动解析并下载所有间接依赖。

### 依赖传递的工作原理
1. **直接依赖**：这是你在 `pom.xml` 文件中明确声明的依赖。
2. **传递依赖**：这是直接依赖所依赖的库。Maven 会递归地解析这些依赖。

例如，如果项目 A 依赖于库 B，而库 B 又依赖于库 C，那么项目 A 在声明对库 B 的依赖后，Maven 也会自动下载库 C。

### 配置依赖传递

#### 示例 `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>my-project</artifactId>
    <version>1.0.0</version>

    <dependencies>
        <!-- 直接依赖库 B -->
        <dependency>
            <groupId>org.example</groupId>
            <artifactId>library-B</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
</project>
```

在上面的示例中，假设 `library-B` 依赖于 `library-C`。你只需在 `pom.xml` 文件中声明 `library-B`，Maven 会自动解析并下载 `library-C`。

### 管理传递依赖

#### 排除不需要的传递依赖

有时，你可能不需要某个传递依赖。在这种情况下，可以使用 `<exclusions>` 标签来排除它。

```xml
<dependency>
    <groupId>org.example</groupId>
    <artifactId>library-B</artifactId>
    <version>1.0.0</version>
    <exclusions>
        <exclusion>
            <groupId>org.example</groupId>
            <artifactId>library-C</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

### 依赖范围（Scope）

Maven 提供了多种依赖范围，以控制依赖的使用范围和生命周期：

- `compile`：默认范围，适用于编译和运行时。
- `provided`：编译时有效，但运行时需要由 JDK 或容器提供。
- `runtime`：运行时有效，但编译时不需要。
- `test`：仅在测试时有效。
- `system`：类似于 `provided`，但需要显式提供一个外部 JAR 文件。
- `import`：用于导入依赖管理的 POM。

```xml
<dependency>
    <groupId>org.example</groupId>
    <artifactId>library-B</artifactId>
    <version>1.0.0</version>
    <scope>test</scope>
</dependency>
```

### 总结
Maven 的依赖传递功能极大地简化了依赖管理过程，但在使用时需注意控制依赖范围，并在必要时排除不需要的传递依赖，以保持项目的简洁和高效。