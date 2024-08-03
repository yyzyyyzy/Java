### 控制反转（IOC）

控制反转是一种设计模式，它将应用程序的控制权从代码内部移交给外部容器或框架。在Spring中，IOC容器负责实例化、配置和组装应用程序中的对象。

**底层逻辑：**
Spring的IOC容器依赖于Java反射机制和配置元数据（如XML配置或注解），根据配置文件或代码中的元数据来创建和管理对象的生命周期。

### 依赖注入（DI）

依赖注入是IOC的一种具体实现方式，通过外部容器将对象的依赖关系注入到对象中，而不是在对象内部创建依赖对象。

**底层逻辑：**
Spring通过构造函数注入、setter方法注入或字段注入来实现依赖注入。这样可以提高代码的灵活性和可测试性。

### 常用的注解及使用

#### 用于IOC的注解

1. **@ComponentScan**：指定Spring扫描的包路径，自动注册符合条件的组件到IOC容器中。

   ```java
   @ComponentScan(basePackages = "com.example")
   ```

2. **@Component**：标识一个类为Spring组件，会被自动扫描并注册到IOC容器中。

   ```java
   @Component
   public class UserService {
       // class body
   }
   ```

3. **@Repository**：标识数据访问层组件，用于访问数据库或其他持久化存储。

   ```java
   @Repository
   public class UserRepository {
       // class body
   }
   ```

4. **@Service**：标识服务层组件，用于定义业务逻辑。

   ```java
   @Service
   public class UserService {
       // class body
   }
   ```

5. **@Configuration** 和 **@Bean**：用于定义配置类，@Configuration标识配置类，@Bean用于声明Bean。

   ```java
   @Configuration
   public class AppConfig {

       @Bean
       public UserService userService() {
           return new UserServiceImpl();
       }
   }
   ```

#### 用于DI的注解

1. **@Autowired**：按照类型自动装配Bean，Spring提供的注解。

   ```java
   @Component
   public class UserController {
       private final UserService userService;

       @Autowired
       public UserController(UserService userService) {
           this.userService = userService;
       }
   }
   ```

2. **@Qualifier**：结合@Autowired一起使用，指定具体的Bean注入。

   ```java
   @Component
   public class UserController {
       private final UserService userService;

       @Autowired
       public UserController(@Qualifier("specificUserService") UserService userService) {
           this.userService = userService;
       }
   }
   ```

3. **@Resource**：根据Bean的名称注入，JDK提供的注解。

   ```java
   @Component
   public class UserController {
       @Resource(name = "userService")
       private UserService userService;
   }
   ```

4. **@Primary**：当一个接口有多个实现类时，标识一个首选的Bean。

   ```java
   @Service
   @Primary
   public class PrimaryUserService implements UserService {
       // class body
   }
   ```

### 总结

这些注解和概念帮助你理解和使用Spring框架中的IOC和DI功能。复习时，理解其背后的原理和使用场景将有助于更高效地开发和管理Spring应用程序的组件和依赖关系。

**IOC注解：**
- @ComponentScan
- @Component
- @Repository
- @Service
- @Configuration
- @Bean

**DI注解：**
- @Autowired
- @Qualifier
- @Resource
- @Primary