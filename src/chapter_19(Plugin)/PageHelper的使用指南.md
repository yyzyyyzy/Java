### PageHelper 插件原理与使用笔记

#### 1. PageHelper 原理解析及 ThreadLocal 的使用

PageHelper 是 MyBatis 的一个分页插件，通过拦截器机制实现数据库查询结果的分页功能。

- **拦截器机制：** PageHelper 通过拦截 MyBatis 的查询方法，捕获用户的分页参数设置。

- **SQL 解析和重写：** 拦截器解析原始 SQL，根据用户设定的分页参数，重写 SQL 以支持数据库的分页查询，如添加 `LIMIT` 或 `ROWNUM`。

- **ThreadLocal 的使用：** PageHelper 使用 ThreadLocal 存储分页参数，确保在同一线程内的数据库查询可以正确识别分页参数，例如当前页码和每页显示数量。这样可以避免多线程环境下的混乱或错误的分页结果。

- **执行查询：** 修改后的 SQL 交由 MyBatis 执行引擎执行查询操作。

- **结果封装：** 查询结果封装成 Page 对象，包含查询到的分页数据及分页相关的元数据。

#### 2. 在 Spring Boot 中使用 PageHelper 插件

在 Spring Boot 中集成 PageHelper 插件通常需要以下步骤：

##### 2.1 添加依赖

首先，在 `pom.xml` 文件中添加 PageHelper 的 Maven 依赖：

```xml
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper-spring-boot-starter</artifactId>
    <version>1.3.0</version> <!-- 替换为最新版本 -->
</dependency>
```

##### 2.2 配置 PageHelper

在 `application.properties` 或 `application.yml` 中配置 PageHelper 的参数：

```properties
# PageHelper 配置
pagehelper.helperDialect=mysql # 数据库类型，根据实际情况选择
pagehelper.reasonable=true     # 分页合理化参数，默认值为 false，设为 true 后会自动修正页码，使不在页数范围内的页码修正为第一页或最后一页
pagehelper.supportMethodsArguments=true # 支持通过 Mapper 方法参数来传递分页参数
pagehelper.params=count=countSql   # 使用方法参数来传递 count 查询的参数
```

##### 2.3 使用示例

在 Spring Boot 的 Service 层或 Controller 层中使用 PageHelper 进行分页查询：

```java
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public PageInfo<User> findAllUsers(int pageNum, int pageSize) {
        // 设置分页参数，开始分页
        PageHelper.startPage(pageNum, pageSize);

        // 执行查询
        List<User> userList = userDao.selectAll();

        // 获取分页信息
        return new PageInfo<>(userList);
    }
}
```

#### 3. 总结与注意事项

- **配置与初始化：** 在 Spring Boot 项目中通过 Maven 导入 PageHelper 的 starter，并在配置文件中设置相关参数。

- **参数设置：** 使用 PageHelper.startPage(pageNum, pageSize) 设置分页参数，pageNum 表示页码，pageSize 表示每页数据条数。

- **查询结果处理：** 使用 PageInfo 对象获取分页的结果数据及分页相关信息。