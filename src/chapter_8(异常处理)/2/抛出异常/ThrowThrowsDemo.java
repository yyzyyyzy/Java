import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThrowThrowsDemo {
    public static void main(String[] args) {
        try {
            // 调用可能抛出异常的方法
            checkNumber(-1);
            readFile("example.txt");
        } catch (IOException | IllegalArgumentException e) {
            // 捕获并处理异常
            System.err.println("Error : " + e.getMessage());
        } finally {
            // 无论是否发生异常，都会执行这里的代码
            System.out.println("Closing resources...");
        }
    }

    // throw 关键字用于在代码中抛出异常
    public static void checkNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
    }

    // throws 关键字用于在方法声明中指定该方法可能抛出的异常。当方法内部抛出指定类型的异常时，该异常会被传递给调用该方法的代码，并在该代码中处理异常。
    public static void readFile(String filename) throws IOException {
        // 尝试打开文件并读取内容
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        System.out.println("Read from file: " + line);
        reader.close();
    }
}
