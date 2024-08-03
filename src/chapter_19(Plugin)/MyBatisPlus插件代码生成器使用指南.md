# MyBatis-Plus 插件代码生成器使用指南

## 1. 引言

MyBatis-Plus 插件提供了一种便捷的方式来生成实体类、Mapper 接口、Mapper XML 文件等。通过 IDE 插件，你可以直接在开发环境中完成代码生成，无需手动编写样板代码。

## 2. 安装插件

### 2.1. IntelliJ IDEA 插件安装

1. **打开 IntelliJ IDEA**，点击菜单栏的 `File` > `Settings`。
2. 在左侧的设置面板中选择 `Plugins`。
3. 搜索 `MyBatis-Plus`，找到 MyBatis-Plus 插件。
4. 点击 `Install` 安装插件。
5. 安装完成后，重启 IDE 使插件生效。

## 3. 配置代码生成器

### 3.1. 创建项目结构

确保项目已经配置了 MyBatis-Plus 的依赖和数据库连接。你的项目结构应该类似于：

- `src/main/java`：存放生成的 Java 类。
- `src/main/resources`：存放生成的 Mapper XML 文件。

### 3.2. 配置数据库连接

在 `application.properties` 或 `application.yml` 文件中配置数据库连接信息：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
spring.datasource.username=root
spring.datasource.password=your_password
```

## 4. 使用插件生成代码

### 4.1. 打开 MyBatis-Plus 插件

1. **打开 IntelliJ IDEA**，在右侧的工具栏中找到 `MyBatis-Plus` 插件图标（通常是一个绿色的方块图标）。
2. 点击该图标，选择 `Code Generator` 选项。

### 4.2. 配置代码生成器

1. **配置数据库连接**：
    - 在插件窗口中，选择 `Datasource`，配置你的数据库连接信息（数据库 URL、用户名、密码等）。
    - 点击 `Test Connection` 确保连接成功。

2. **选择数据库表**：
    - 在 `Table` 选项卡中，选择你要生成代码的表。
    - 可以选择单个表或多个表。

3. **设置生成选项**：
    - 在 `Generate` 选项卡中，配置代码生成的选项，包括生成的文件类型（如实体类、Mapper 接口、Mapper XML 文件等）、包名、输出目录等。
    - 你可以选择是否覆盖已有文件。

4. **选择生成策略**：
    - 在 `Strategy` 选项卡中，设置生成策略，如命名策略（下划线转驼峰）、逻辑删除字段、乐观锁字段等。
    - 配置其他选项，如生成的 Java 类是否使用 Lombok、是否生成 ResultMap 等。

### 4.3. 执行生成

- 配置完成后，点击 `Generate` 按钮，插件会根据配置生成相应的代码文件。
- 生成的代码文件会被自动放置在你指定的目录下，例如 `src/main/java` 和 `src/main/resources/mapper`。

## 5. 示例

假设你有一个名为 `user` 的数据库表，配置完成后，你将会得到以下文件：

### User.java

```java
package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String phone;

    private Integer balance;

    private String info;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
```

### UserMapper.java

```java
package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;

public interface UserMapper extends BaseMapper<User> {
}
```

### UserMapper.xml

```xml
<mapper namespace="com.example.demo.mapper.UserMapper">
    <resultMap id="BaseResultMap" type="com.example.demo.entity.User">
        <id column="id" property="id" jdbcType="BIGINT"/>
        <result column="username" property="username" jdbcType="VARCHAR"/>
        <result column="password" property="password" jdbcType="VARCHAR"/>
        <result column="phone" property="phone" jdbcType="VARCHAR"/>
        <result column="balance" property="balance" jdbcType="INTEGER"/>
        <result column="info" property="info" jdbcType="VARCHAR"/>
        <result column="create_time" property="createTime" jdbcType="TIMESTAMP"/>
        <result column="update_time" property="updateTime" jdbcType="TIMESTAMP"/>
    </resultMap>

    <sql id="Base_Column_List">
        id, username, password, phone, balance, info, create_time, update_time
    </sql>
</mapper>
```

## 6. 注意事项

- **数据库连接**：确保数据库连接信息配置正确。
- **覆盖文件**：插件会根据配置覆盖已有的代码文件，请谨慎操作。
- **命名策略**：根据项目需求选择合适的命名策略。

## 7. 总结

MyBatis-Plus 插件的代码生成器功能可以大大提高开发效率，通过配置和使用插件，你可以快速生成实体类、Mapper 接口、Mapper XML 文件等。熟练掌握插件的使用，可以使你的开发过程更加高效和规范。

## 8. 参考文献

- [MyBatis-Plus 插件官方文档](https://mybatis.plus/guide/generator.html)
- [IntelliJ IDEA 插件市场](https://plugins.jetbrains.com/)
