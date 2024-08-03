## Spring Boot 常用注解总结

### 1. `@SpringBootApplication`

这是一个综合注解，它包括了`@Configuration`、`@EnableAutoConfiguration` 和 `@ComponentScan`，用于标记主配置类，自动配置Spring Boot应用。

**示例代码：**
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

**作用说明：**
- `@Configuration`：指示这个类可以使用Spring IoC容器作为配置类。
- `@EnableAutoConfiguration`：启用Spring Boot的自动配置。
- `@ComponentScan`：自动扫描组件（Bean），包括当前包及其子包。

---

### 2. `@Controller`

用于定义控制器类，处理Web请求。

**示例代码：**
```java
@Controller
public class WebController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "hello";
    }
}
```

**作用说明：**
- 用于处理Web请求并返回视图名称。

---

### 3. `@RestController`

`@RestController`是`@Controller`和`@ResponseBody`的组合，处理RESTful Web服务，返回JSON或XML数据。

**示例代码：**
```java
@RestController
public class RestApiController {

    @GetMapping("/api/greet")
    public Map<String, String> greet() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World!");
        return response;
    }
}
```

**作用说明：**
- 返回的数据会被自动转换为JSON格式。

---

### 4. `@RequestMapping`

用于定义请求映射，可以应用于类或方法级别，支持多种请求方法（GET, POST, PUT, DELETE等）。

**示例代码：**
```java
@RequestMapping(value = "/api/hello", method = RequestMethod.GET)
public String hello() {
    return "Hello, World!";
}
```

**作用说明：**
- 映射HTTP请求到处理方法上。

---

### 5. `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`

这些注解是`@RequestMapping`的快捷方式，分别用于处理HTTP GET、POST、PUT和DELETE请求。

**示例代码：**
```java
@GetMapping("/api/users")
public List<User> getUsers() {
    return userService.getAllUsers();
}

@PostMapping("/api/users")
public User createUser(@RequestBody User user) {
    return userService.saveUser(user);
}

@PutMapping("/api/users/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    return userService.updateUser(id, user);
}

@DeleteMapping("/api/users/{id}")
public void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
}
```

**作用说明：**
- 用于简化`@RequestMapping`的用法，明确指定HTTP方法类型。

---

### 6. `@Autowired`

用于自动注入Bean，可以注入Spring容器中的依赖。

**示例代码：**
```java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
```

**作用说明：**
- 自动装配Bean，不需要手动创建和管理Bean实例。

---

### 7. `@Qualifier`

用于指定注入Bean的名称，当有多个相同类型的Bean时使用。

**示例代码：**
```java
@Service
public class UserService {

    @Autowired
    @Qualifier("userRepositoryImpl")
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
```

**作用说明：**
- 与`@Autowired`结合使用，用于指定注入的Bean名称。

---

### 8. `@Component`

用于标记一个类为Spring容器中的组件（Bean），可以被自动发现和装配。

**示例代码：**
```java
@Component
public class MyComponent {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}
```

**作用说明：**
- 与`@Service`、`@Repository`和`@Controller`等注解功能相似，用于标记类为Spring管理的组件。

---

### 9. `@Service`

标记一个服务层的组件，用于业务逻辑层。

**示例代码：**
```java
@Service
public class UserService {
    // Business logic methods
}
```

**作用说明：**
- 用于业务逻辑层的服务类，表明其角色是服务提供者。

---

### 10. `@Repository`

标记一个数据访问层的组件，用于持久层。

**示例代码：**
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Data access methods
}
```

**作用说明：**
- 用于数据访问层，表明该类负责数据库操作。

---

### 11. `@Configuration`

用于定义配置类，Spring会把带有该注解的类作为Spring配置类处理。

**示例代码：**
```java
@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        return new DataSource();
    }
}
```

**作用说明：**
- 用于定义bean及其依赖的配置类。

---

### 12. `@Bean`

用于定义一个Bean，它会被Spring容器管理。

**示例代码：**
```java
@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```

**作用说明：**
- 用于将方法的返回值注册为Spring容器中的一个Bean。

---

### 13. `@Value`

用于注入属性值，可以从配置文件中读取。

**示例代码：**
```java
@Component
public class MyComponent {

    @Value("${app.name}")
    private String appName;

    public void printAppName() {
        System.out.println("Application Name: " + appName);
    }
}
```

**作用说明：**
- 用于注入配置文件中的属性值。

---

### 14. `@Profile`

用于根据不同的环境激活不同的Bean配置。

**示例代码：**
```java
@Configuration
@Profile("dev")
public class DevConfig {

    @Bean
    public DataSource dataSource() {
        return new DevDataSource();
    }
}
```

**作用说明：**
- 用于指定Bean的创建与激活条件，根据不同的环境配置不同的Bean。

---

### 15. `@PropertySource`

用于指定配置文件的位置，以便Spring能加载这些属性值。

**示例代码：**
```java
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    // Configuration code
}
```

**作用说明：**
- 用于加载外部配置文件中的属性。

---

### 16. `@Transactional`

用于声明事务处理，确保操作的一致性和完整性。

**示例代码：**
```java
@Service
public class UserService {

    @Transactional
    public void createUser(User user) {
        // Business logic
    }
}
```

**作用说明：**
- 用于确保方法内的操作要么全部成功，要么全部失败。

---

### 总结

1. **`@SpringBootApplication`**：综合配置注解，用于标记Spring Boot应用的主配置类。
2. **`@Controller`**：用于定义控制器类，处理Web请求。
3. **`@RestController`**：用于定义RESTful Web服务控制器，返回JSON/XML数据。
4. **`@RequestMapping`**：用于映射HTTP请求到处理方法上。
5. **`@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`**：处理HTTP GET、POST、PUT和DELETE请求。
6. **`@Autowired`**：自动注入Bean。
7. **`@Qualifier`**：指定注入Bean的名称。
8. **`@Component`**：标记一个类为Spring容器中的组件。
9. **`@Service`**：标记服务层组件。
10. **`@Repository`**：标记数据访问层组件。
11. **`@Configuration`**：定义配置类。
12. **`@Bean`**：定义Bean。
13. **`@Value`**：注入属性值。
14. **`@Profile`**：根据环境激活不同的Bean配置。
15. **`@PropertySource`**：指定配置文件的位置。
16. **`@Transactional`**：声明事务处理。

---