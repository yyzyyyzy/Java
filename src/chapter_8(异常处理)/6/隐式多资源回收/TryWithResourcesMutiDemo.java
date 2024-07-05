import java.io.*;

public class TryWithResourcesMutiDemo {
    public static void main(String[] args) {
        // 使用 try-with-resources 结构打开文件并读取内容
        try (
                BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 将读取的内容写入到输出文件
                writer.write(line);
                writer.newLine(); // 写入换行符
            }
        } catch (IOException e) {
            // 捕获并处理IO异常
            System.err.println("Error: " + e.getMessage());
        }
    }
}