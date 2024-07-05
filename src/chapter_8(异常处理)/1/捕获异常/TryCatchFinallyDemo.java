import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchFinallyDemo {
    public static void main(String[] args) {
        try {
            // 尝试打开文件并读取内容
            BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
            String line = reader.readLine();
            System.out.println("Read from file: " + line);
            reader.close();
        } catch (IOException e) {
            // 捕获并处理IO异常
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            // 无论是否发生异常，都会执行这里的代码
            System.out.println("Closing resources...");
        }
    }
}
