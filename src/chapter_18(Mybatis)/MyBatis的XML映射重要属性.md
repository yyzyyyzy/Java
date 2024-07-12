# MyBatis XML 映射重要字段和属性

在使用 MyBatis 进行 XML 映射时，有一些关键字段和属性需要特别注意。以下是这些字段和属性的详细解释和示例。

## 1. `namespace`

`namespace` 用于区分不同的 `mapper`，避免 SQL 语句 ID 冲突。通常 `namespace` 的值为对应的 `Mapper` 接口的全限定名（包名+类名）。

```xml
<mapper namespace="com.itlizikang.mapper.EmployeeMapper">
    <!-- 其他映射配置 -->
</mapper>
```

## 2. `resultType`

`resultType` 用于指定查询结果的 Java 类型。可以是基本类型或自定义的 Java 类。

```xml
<select id="getEmployeeById" parameterType="long" resultType="com.itlizikang.model.Employee">
    SELECT * FROM employee WHERE id = #{id}
</select>
```

## 3. `resultMap`

`resultMap` 用于更复杂的结果映射，特别是在结果集字段名与 Java 类字段名不一致时使用。

```xml
<resultMap id="EmployeeResultMap" type="com.itlizikang.model.Employee">
    <id property="id" column="id"/>
    <result property="name" column="name"/>
    <result property="age" column="age"/>
    <!-- 其他字段映射 -->
</resultMap>

<select id="getEmployeeById" parameterType="long" resultMap="EmployeeResultMap">
SELECT * FROM employee WHERE id = #{id}
</select>
```

## 4. `parameterType`

`parameterType` 用于指定传递给 SQL 语句的参数的 Java 类型。可以是基本类型或自定义的 Java 类。

```xml
<select id="getEmployeeById" parameterType="long" resultType="com.itlizikang.model.Employee">
    SELECT * FROM employee WHERE id = #{id}
</select>
```

## 5. `useGeneratedKeys` 和 `keyProperty`

`useGeneratedKeys` 和 `keyProperty` 用于插入操作中获取数据库自动生成的主键值。

```xml
<insert id="insertEmployee" parameterType="com.itlizikang.model.Employee" useGeneratedKeys="true" keyProperty="id">
    INSERT INTO employee (name, age, street, city, state, zip, integers, strings, local_date_time)
    VALUES (#{name}, #{age}, #{street}, #{city}, #{state}, #{zip}, #{integers}, #{strings}, #{localDateTime})
</insert>
```

## 6. `selectKey`

`selectKey` 用于在插入前或插入后获取某些数据库生成的值（例如，主键）。

```xml
<insert id="insertEmployee" parameterType="com.itlizikang.model.Employee">
    <selectKey keyProperty="id" resultType="long" order="BEFORE">
        SELECT NEXT VALUE FOR my_sequence
    </selectKey>
    INSERT INTO employee (id, name, age, street, city, state, zip, integers, strings, local_date_time)
    VALUES (#{id}, #{name}, #{age}, #{street}, #{city}, #{state}, #{zip}, #{integers}, #{strings}, #{localDateTime})
</insert>
```

## 7. `<sql>` 片段

`<sql>` 元素用于定义可重用的 SQL 片段，可以在多个语句中使用。

```xml
<sql id="employeeColumns">
    id, name, age, street, city, state, zip, integers, strings, local_date_time
</sql>

<select id="getAllEmployees" resultType="com.itlizikang.model.Employee">
SELECT <include refid="employeeColumns"/> FROM employee
</select>
```

## 8. `<include>`

`<include>` 元素用于包含定义的 SQL 片段。

```xml
<select id="getAllEmployees" resultType="com.itlizikang.model.Employee">
    SELECT <include refid="employeeColumns"/> FROM employee
</select>
```

## 9. 动态 SQL

MyBatis 支持动态 SQL，使用 `<if>`、`<choose>`、`<when>`、`<otherwise>`、`<foreach>` 等标签来实现。

```xml
<select id="getEmployees" parameterType="map" resultType="com.itlizikang.model.Employee">
    SELECT *
    FROM employee
    <where>
        <if test="name != null">
            AND name LIKE CONCAT('%', #{name}, '%')
        </if>
        <if test="street != null">
            AND street = #{street}
        </if>
        <if test="city != null">
            AND city = #{city}
        </if>
    </where>
    ORDER BY age DESC
</select>
```

### 9.1 `<where>` 标签

`<where>` 标签用于动态地构建 SQL 语句中的 WHERE 子句。它的主要功能是简化条件语句的编写，同时自动处理 AND 或 OR 连接符的添加，使得 SQL 语句更加简洁和易于维护。

#### 使用方法：

`<where>` 标签会自动添加一个 "WHERE" 关键字，并会去掉多余的 AND 或 OR。它能够包含任意数量的 `<if>`、`<choose>`、`<when>`、`<otherwise>`、`<foreach>` 等标签，以便根据条件动态生成 SQL 语句。

#### 示例：

```xml
<select id="getEmployees" parameterType="map" resultType="com.itlizikang.model.Employee">
    SELECT *
    FROM employee
    <where>
        <if test="name != null">
            AND name LIKE CONCAT('%', #{name}, '%')
        </if>
        <if test="street != null">
            AND street = #{street}
        </if>
        <if test="city != null">
            AND city = #{city}
        </if>
    </where>
    ORDER BY age DESC
</select>
```

在上面的示例中，`<where>` 标签的作用如下：

1. **自动添加 WHERE 关键字**：如果有任何一个 `<if>` 条件为真，`<where>` 标签会自动在生成的 SQL 语句中添加一个 WHERE 关键字。

2. **处理多余的 AND/OR**：如果条件为真，`<where>` 标签会将第一个条件前的 AND 去掉，只保留后续条件之间的 AND。这样可以避免手动添加 AND 时出现的语法错误。

3. **简化 SQL 编写**：通过使用 `<where>` 标签，可以避免手动管理条件连接符，减少代码冗余，使 SQL 语句更加简洁和易于阅读。

#### 注意事项

- 当没有任何一个条件为真时，`<where>` 标签不会在生成的 SQL 语句中添加 WHERE 关键字。
- 确保在 `<if>` 条件中使用正确的逻辑判断，以避免 SQL 注入和其他安全问题。

通过使用 MyBatis 的 `<where>` 标签，可以大大简化动态 SQL 的编写，使代码更加简洁和维护更加方便。

### 9.2 `<set>` 标签

`<set>` 标签用于动态地构建 SQL 语句中的 SET 子句，主要用于更新操作。它的主要功能是简化条件语句的编写，同时自动处理逗号的添加，使得 SQL 语句更加简洁和易于维护。

#### 使用方法：

`<set>` 标签会自动添加一个 "SET" 关键字，并会去掉多余的逗号。它能够包含任意数量的 `<if>`、`<choose>`、`<when>`、`<otherwise>`、`<foreach>` 等标签，以便根据条件动态生成 SQL 语句。

#### 示例：

```xml
<update id="updateEmployee" parameterType="com.itlizikang.model.Employee">
    UPDATE employee
    <set>
        <if test="name != null">
            name = #{name},
        </if>
        <if test="age != null">
            age = #{age},
        </if>
        <if test="street != null">
            street = #{street},
        </if>
        <if test="city != null">
            city = #{city},
        </if>
    </set>
    WHERE id = #{id}
</update>
```

在上面的示例中，`<set>` 标签的作用如下：

1. **自动添加 SET 关键字**：如果有任何一个 `<if>` 条件为真，`<set>` 标签会自动在生成的 SQL 语句中添加一个 SET 关键字。

2. **处理多余的逗号**：如果条件为真，`<set>` 标签会将第一个条件前的逗号去掉，只保留后续条件之间的逗号。这样可以避免手动添加逗号时出现的语法错误。

3. **简化 SQL 编写**：通过使用 `<set>` 标签，可以避免手动管理条件连接符，减少代码冗余，使 SQL 语句更加简洁和易于阅读。

#### 注意事项

- 当没有任何一个条件为真时，`<set>` 标签不会在生成的 SQL 语句中添加 SET 关键字。
- 确保在 `<if>` 条件中使用正确的逻辑判断，以避免 SQL 注入和其他安全

问题。

通过使用 MyBatis 的 `<set>` 标签，可以大大简化动态 SQL 的编写，使代码更加简洁和维护更加方便。

### 9.3 `<foreach>` 标签

`<foreach>` 标签用于在 SQL 语句中动态地遍历集合，通常用于 IN 子句或批量插入操作。以下是各个属性的详细解释和示例：

- `collection`: 指定要遍历的集合。通常对应于传入参数的名称或默认值 `list`。
- `item`: 指定集合中的每一项在循环中的别名。
- `separator`: 指定集合项之间的分隔符，例如逗号。
- `open`: 指定循环开始时添加的字符，例如左括号。
- `close`: 指定循环结束时添加的字符，例如右括号。

#### 示例：

```xml
<select id="getEmployeesByIds" parameterType="list" resultType="com.itlizikang.model.Employee">
    SELECT * FROM employee WHERE id IN 
    <foreach collection="list" item="id" separator="," open="(" close=")">
        #{id}
    </foreach>
</select>
```

在上面的示例中：

- `collection="list"`: 遍历名为 `list` 的集合。
- `item="id"`: 每个集合项在循环中使用别名 `id`。
- `separator=","`: 每个集合项之间使用逗号分隔。
- `open="("` 和 `close=")"`: 循环开始和结束时分别添加左括号和右括号。

通过使用 MyBatis 的 `<foreach>` 标签，可以方便地在 SQL 语句中处理集合参数，简化批量操作的实现。

## 10. 缓存配置

MyBatis 支持一级缓存和二级缓存，通过 XML 配置可以启用和配置缓存。

### 一级缓存

一级缓存是 SqlSession 级别的缓存，默认启用。

### 二级缓存

二级缓存是 Mapper 级别的缓存，需要在 XML 中配置。

```xml
<cache/>
```

或

```xml
<cache type="com.mycompany.MyCustomCache"/>
```

### 缓存示例

```xml
<mapper namespace="com.itlizikang.mapper.EmployeeMapper">
    <cache/>

    <select id="getEmployeeById" parameterType="long" resultType="com.itlizikang.model.Employee">
        SELECT * FROM employee WHERE id = #{id}
    </select>
</mapper>
```

## 总结

这些字段和属性提供了强大的功能和灵活性，允许开发人员根据需求进行复杂的 SQL 映射和优化。理解和熟练使用这些字段和属性是高效使用 MyBatis 的关键。