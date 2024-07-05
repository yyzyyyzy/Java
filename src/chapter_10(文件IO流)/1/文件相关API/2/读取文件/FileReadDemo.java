import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadDemo {
    public static void main(String[] args) {
        //使用BufferedReader逐行读取
        try (BufferedReader reader = new BufferedReader(new FileReader("文件路径"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 处理每一行数据
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //如果文件不大，可以使用Files.readAllLines(Path path)来一次性读取所有行到内存中，适合小文件
        Path filePath = Paths.get("文件路径");
        try {
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}