import java.io.*;
import java.util.Properties;

/*
    特点:
        键值对：每行表示一个键值对，例如key=value。
        注释：以井号（#）开头的行是注释，不会被解析。
        空格和空行：空格和空行会被忽略。
        多行值：如果值很长，可以使用反斜杠（\）进行续行。
 */

public class PropertiesAPIDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();

        // 1.加载属性文件
        try (InputStream input = new FileInputStream("D:\\桌面文件\\奇安信——工作记录\\AllTime——代码——nac代码\\javaTest\\src\\chapter_10(文件IO流)\\6\\配置文件相关API\\config.properties")) {
            properties.load(input);

            // 获取属性值
            String dbUrl = properties.getProperty("database.url");
            String dbUsername = properties.getProperty("database.username");
            String dbPassword = properties.getProperty("database.password");

            System.out.println("Database URL: " + dbUrl);
            System.out.println("Database Username: " + dbUsername);
            System.out.println("Database Password: " + dbPassword);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // 2.写入属性文件
        properties.setProperty("database.url", "jdbc:mysql://localhost:3306/mydatabase");
        properties.setProperty("database.username", "root");
        properties.setProperty("database.password", "secret");

        try (OutputStream output = new FileOutputStream("D:\\桌面文件\\奇安信——工作记录\\AllTime——代码——nac代码\\javaTest\\src\\chapter_10(文件IO流)\\6\\配置文件相关API\\config.properties")) {
            // 保存属性到文件
            properties.store(output, "Database Configuration");

            System.out.println("Properties file updated successfully!");

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
