### Maven 依赖范围（Scope）

Maven 提供了多种依赖范围，以控制依赖的使用范围和生命周期：

#### 1. `compile`
- **默认范围**：如果没有指定 scope，这就是默认的范围。
- **用途**：适用于编译和运行时。
- **示例**：

  ```xml
  <dependency>
      <groupId>org.example</groupId>
      <artifactId>library-A</artifactId>
      <version>1.0.0</version>
      <scope>compile</scope>
  </dependency>
  ```

#### 2. `provided`
- **用途**：编译时有效，但运行时需要由 JDK 或容器提供。
- **典型应用**：例如 servlet-api，这些库在容器中已经提供。
- **示例**：

  ```xml
  <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
      <scope>provided</scope>
  </dependency>
  ```

#### 3. `runtime`
- **用途**：运行时有效，但编译时不需要。
- **示例**：

  ```xml
  <dependency>
      <groupId>org.example</groupId>
      <artifactId>library-B</artifactId>
      <version>1.0.0</version>
      <scope>runtime</scope>
  </dependency>
  ```

#### 4. `test`
- **用途**：仅在测试时有效。
- **示例**：

  ```xml
  <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
  </dependency>
  ```

#### 5. `system`
- **用途**：类似于 `provided`，但需要显式提供一个外部 JAR 文件。
- **注意**：必须提供 `<systemPath>`。
- **示例**：

  ```xml
  <dependency>
      <groupId>com.example</groupId>
      <artifactId>library-C</artifactId>
      <version>1.0.0</version>
      <scope>system</scope>
      <systemPath>${project.basedir}/lib/library-C-1.0.0.jar</systemPath>
  </dependency>
  ```

#### 6. `import`
- **用途**：用于导入依赖管理的 POM。
- **应用场景**：通常用于 `dependencyManagement` 中。
- **示例**：

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-dependencies</artifactId>
      <version>2.3.4.RELEASE</version>
      <type>pom</type>
      <scope>import</scope>
  </dependency>
  ```

### 总结
理解和正确使用 Maven 的依赖范围，可以帮助你更好地管理项目依赖，确保在不同的编译和运行阶段正确地引入和排除必要的库。