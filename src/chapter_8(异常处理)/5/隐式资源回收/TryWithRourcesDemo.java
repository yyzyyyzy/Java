import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*

JDK7 之后，Java 新增的 try-with-resource 语法结构，旨在自动管理资源，确保资源在使用后能够及时关闭，避免资源泄露。
try-with-resources 是一种异常处理机制，它能够自动关闭在 try 块中声明的资源，无需显式地在 finally 块中关闭。
在 try-with-resources 语句中，你只需要在 try 关键字后面声明资源，然后跟随一个代码块。
无论代码块中的操作是否成功，资源都会在 try 代码块执行完毕后自动关闭。

try (resource declaration) {
  // 使用的资源
} catch (ExceptionType e1) {
  // 异常块
}

 */
public class TryWithRourcesDemo {
    public static void main(String[] args) {
        // 使用 try-with-resources 结构打开文件并读取内容
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line = reader.readLine();
            System.out.println("Read from file: " + line);
        } catch (IOException e) {
            // 捕获并处理IO异常
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}