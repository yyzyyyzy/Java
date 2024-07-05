import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteDemo {
    public static void main(String[] args) {
        String filePath = "文件路径";
        String content = "要写入的内容";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            writer.newLine(); // 写入换行符
            // 可以继续追加更多内容...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
