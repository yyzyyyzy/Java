当在Spring Boot项目中使用Knife4j（Swagger-Bootstrap-UI）时，可以按照以下完整步骤进行配置和使用。Knife4j是Swagger UI的增强版本，提供了更多的功能和定制选项，使得API文档的管理和展示更加便捷和美观。

### 步骤一：添加依赖

首先，在你的Spring Boot项目的`pom.xml`文件中添加Knife4j的依赖：

```xml
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-spring-boot-starter</artifactId>
    <version>3.0.2</version> <!-- 替换为最新版本 -->
</dependency>
```

### 步骤二：Swagger配置

将Swagger配置放在实现了`WebMvcConfigurer`接口的配置类中，例如 `WebMvcConfig` 类中。这种做法非常常见，特别是当你需要集中管理项目中的所有配置时。

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableSwagger2
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Knife4j静态资源映射
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.your.package.controller")) // 替换为你的controller所在的包名
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档")
                .description("API文档和接口测试")
                .version("1.0")
                .build();
    }
}
```

### 步骤三：访问Knife4j界面

启动你的Spring Boot应用程序，然后可以通过以下地址访问Knife4j UI界面：

```
http://localhost:8080/doc.html
```

通过以上完整步骤和常用功能，你可以方便地在Spring Boot项目中集成并使用Knife4j来管理和展示API文档。希望这些信息对你有帮助！如果有任何疑问或者需要进一步的帮助，请随时告诉我。