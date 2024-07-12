# MyBatis `@Results` 注解

## 作用
MyBatis 的 `@Results` 注解用于将 SQL 查询结果映射到 Java 对象的属性。通常与 `@Result` 注解结合使用，以定义每个列与对象属性之间的映射关系。

### 主要功能
1. **指定映射关系**：通过 `@Results` 注解，可以明确指定查询结果中的列和 Java 对象属性之间的映射关系。
2. **解决字段名和属性名不一致的问题**：如果查询结果中的列名与 Java 对象的属性名不一致，可以通过 `@Result` 注解来解决。

## 示例

### Java 类
假设有一个 `Employee` 类如下：

```java
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private String street;
    private String city;
    private String state;
    private String zip;

    // Getter 和 Setter 方法
}
```

### 数据库表
假设有一个对应的数据库表 `employees`，包含以下列：
- `emp_id`
- `emp_name`
- `emp_age`
- `emp_street`
- `emp_city`
- `emp_state`
- `emp_zip`

### MyBatis 映射
如果列名和属性名不一致，我们可以使用 `@Results` 和 `@Result` 注解来指定映射关系：

```java
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT emp_id, emp_name, emp_age, emp_street, emp_city, emp_state, emp_zip FROM employees WHERE emp_id = #{id}")
    @Results({
        @Result(property = "id", column = "emp_id"),
        @Result(property = "name", column = "emp_name"),
        @Result(property = "age", column = "emp_age"),
        @Result(property = "street", column = "emp_street"),
        @Result(property = "city", column = "emp_city"),
        @Result(property = "state", column = "emp_state"),
        @Result(property = "zip", column = "emp_zip")
    })
    Employee getEmployeeById(Integer id);
}
```

### 解释
- `@Select` 注解用于定义要执行的 SQL 查询。
- `@Results` 注解用于定义一组 `@Result` 注解，每个 `@Result` 注解定义一个属性和列之间的映射关系。
  - `property` 指定 Java 对象的属性名。
  - `column` 指定 SQL 查询结果中的列名。

通过这种方式，MyBatis 可以将 SQL 查询结果正确映射到 Java 对象的属性中，即使它们的名称不一致。

## 使用 `map-underscore-to-camel-case=true` 配置

MyBatis 提供了一种简化映射的方式，通过设置 `map-underscore-to-camel-case=true`，可以自动将数据库列名中的下划线格式映射为 Java 对象的驼峰命名格式属性。

### 配置方式
在 MyBatis 的配置文件中添加以下设置：

```xml
<settings>
    <setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>
```

或者在 Spring Boot 的 `application.properties` 文件中添加：

```properties
mybatis.configuration.map-underscore-to-camel-case=true
```

### 示例
假设有一个数据库表 `employees`，包含列名如下：
- `emp_id`
- `emp_name`
- `emp_age`
- `emp_street`
- `emp_city`
- `emp_state`
- `emp_zip`

而你的 `Employee` 类如下：

```java
public class Employee {
    private Integer empId;
    private String empName;
    private Integer empAge;
    private String empStreet;
    private String empCity;
    private String empState;
    private String empZip;

    // Getter 和 Setter 方法
}
```

在 MyBatis 的配置文件中设置 `map-underscore-to-camel-case=true` 后，可以简化 Mapper 接口中的映射配置：

```java
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT emp_id, emp_name, emp_age, emp_street, emp_city, emp_state, emp_zip FROM employees WHERE emp_id = #{id}")
    Employee getEmployeeById(Integer id);
}
```

### 解释
通过设置 `map-underscore-to-camel-case=true`，MyBatis 会自动将查询结果中的下划线命名风格的列名映射到 Java 对象的驼峰命名风格的属性名。例如：
- `emp_id` 会映射到 `empId`。
- `emp_name` 会映射到 `empName`。

这种方式简化了映射配置，使得代码更加清晰和易于维护。