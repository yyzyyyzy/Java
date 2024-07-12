# MyBatis 映射方式

MyBatis 是一种优秀的持久层框架，它支持通过 XML 文件或注解的方式进行 SQL 映射。本文将介绍 MyBatis 的两种主要映射方式：注解方式和 XML 文件方式。

## 1. 注解方式

注解方式是 MyBatis 提供的一种简洁的配置方式，使用 Java 注解来直接在接口中定义 SQL 语句。

### 优点

- **简洁明了**：SQL 语句直接嵌入在代码中，易于理解和维护。
- **减少配置文件**：不需要额外的 XML 配置文件。

### 缺点

- **灵活性较差**：对于复杂的 SQL 语句和动态 SQL 支持不够灵活。
- **代码冗长**：大量的 SQL 语句嵌入在代码中，会使代码变得冗长。

### 示例

```java
package com.itlizikang.mapper;

import com.itlizikang.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getEmployeeById(Long id);

    @Select("SELECT * FROM employee")
    List<Employee> getAllEmployees();

    @Select("SELECT * FROM employee WHERE name LIKE CONCAT('%', #{name}, '%') ORDER BY age DESC")
    List<Employee> getEmployees(String name);

    @Insert("INSERT INTO employee (name, age, street, city, state, zip, integers, strings, local_date_time) " +
            "VALUES (#{name}, #{age}, #{street}, #{city}, #{state}, #{zip}, #{integers}, #{strings}, #{localDateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertEmployee(Employee employee);

    @Update("UPDATE employee SET name = #{name}, age = #{age}, street = #{street}, city = #{city}, " +
            "state = #{state}, zip = #{zip}, integers = #{integers}, strings = #{strings}, " +
            "local_date_time = #{localDateTime} WHERE id = #{id}")
    void updateEmployee(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void deleteEmployee(Long id);
}
```

## 2. XML 文件方式

XML 文件方式是 MyBatis 最传统和经典的配置方式，使用 XML 文件来定义 SQL 语句和映射关系。

### 优点

- **灵活性强**：支持复杂的 SQL 语句和动态 SQL 配置。
- **分离关注点**：SQL 语句和 Java 代码分离，便于管理和维护。

### 缺点

- **配置文件较多**：需要额外的 XML 配置文件，增加了配置文件的数量。
- **不直观**：SQL 语句和 Java 代码分离，可能不直观。

### 示例

#### XML 配置文件 (EmployeeMapper.xml)

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.itlizikang.mapper.EmployeeMapper">

    <select id="getEmployeeById" parameterType="long" resultType="com.itlizikang.model.Employee">
        SELECT * FROM employee WHERE id = #{id}
    </select>

    <select id="getAllEmployees" resultType="com.itlizikang.model.Employee">
        SELECT * FROM employee
    </select>

    <select id="getEmployees" parameterType="string" resultType="com.itlizikang.model.Employee">
        SELECT * FROM employee WHERE name LIKE CONCAT('%', #{name}, '%') ORDER BY age DESC
    </select>

    <insert id="insertEmployee" parameterType="com.itlizikang.model.Employee" useGeneratedKeys="true" keyProperty="id">
        INSERT INTO employee (name, age, street, city, state, zip, integers, strings, local_date_time)
        VALUES (#{name}, #{age}, #{street}, #{city}, #{state}, #{zip}, #{integers}, #{strings}, #{localDateTime})
    </insert>

    <update id="updateEmployee" parameterType="com.itlizikang.model.Employee">
        UPDATE employee SET 
            name = #{name}, 
            age = #{age}, 
            street = #{street}, 
            city = #{city}, 
            state = #{state}, 
            zip = #{zip}, 
            integers = #{integers}, 
            strings = #{strings}, 
            local_date_time = #{localDateTime} 
        WHERE id = #{id}
    </update>

    <delete id="deleteEmployee" parameterType="long">
        DELETE FROM employee WHERE id = #{id}
    </delete>

</mapper>
```

#### 接口定义 (EmployeeMapper.java)

```java
package com.itlizikang.mapper;

import com.itlizikang.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    List<Employee> getEmployees(String name);

    void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Long id);
}
```

## 3. 总结

### 注解方式适合场景

- 简单的 CRUD 操作
- 项目规模较小
- 追求快速开发

### XML 文件方式适合场景

- 复杂的 SQL 语句和动态 SQL
- 需要灵活配置
- 关注 SQL 和代码的分离