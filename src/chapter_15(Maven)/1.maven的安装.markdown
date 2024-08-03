# Maven 安装指南

## 步骤 1：下载 Apache Maven

1. 打开浏览器，访问 [Apache Maven 下载页面](https://maven.apache.org/download.cgi)。
2. 下载 `apache-maven-3.9.8-bin.zip` 文件。

## 步骤 2：解压文件

1. 将下载的 `apache-maven-3.9.8-bin.zip` 文件解压到 `D:\maven` 目录。

## 步骤 3：配置 Maven

1. 打开 `D:\maven\conf\settings.xml` 文件进行编辑。
2. 添加或修改以下配置：

    - 设置本地仓库路径：
      ```xml
      <localRepository>D:\maven\mvn_repo</localRepository>
      ```
    - 添加阿里云镜像：
      ```xml
      <mirror>
          <id>maven-ali</id>
          <mirrorOf>central</mirrorOf>
          <name>aliyun maven</name>
          <url>http://maven.aliyun.com/nexus/content/groups/public</url>
      </mirror>
      ```

## 步骤 4：设置环境变量

1. 打开系统环境变量设置界面：
    - 右键点击“此电脑”图标，选择“属性”。
    - 点击“高级系统设置”。
    - 在“系统属性”窗口中，点击“环境变量”按钮。

2. 新增系统变量：
    - 变量名：`Maven_Home`
    - 变量值：`D:\maven`

3. 编辑 `Path` 系统变量，新增：
    - `%Maven_Home%\bin`

## 步骤 5：验证安装

1. 打开命令提示符（CMD）。
2. 输入以下命令检查 Maven 是否安装成功：
   ```sh
   mvn -v

