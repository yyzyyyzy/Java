## Maven 的依赖配置

### 1. 打开 Maven Repository
首先，打开浏览器并访问 [Maven Repository](https://mvnrepository.com/)。

### 2. 搜索依赖
在搜索栏输入你需要的依赖名称，例如“JUnit”，然后点击搜索。

### 3. 选择合适的版本
在搜索结果中选择合适的版本，例如 JUnit 5.7.0 版本，并复制相应的依赖配置：

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.7.0</version>
    <scope>test</scope>
</dependency>
```

### 4. 打开项目的 pom.xml 文件
打开你的项目的 `pom.xml` 文件。

### 5. 添加依赖配置
将复制的依赖配置粘贴到 `<dependencies>` 节点中：

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.7.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### 6. 保存 pom.xml 文件
保存 `pom.xml` 文件。

### 7. 下载依赖
在命令提示符中进入项目目录，运行以下命令下载依赖：

```sh
mvn clean install
```

完成以上步骤后，Maven 将自动下载并添加所需的依赖到你的项目中。