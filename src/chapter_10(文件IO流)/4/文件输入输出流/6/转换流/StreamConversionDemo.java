import java.io.*;
import java.nio.charset.StandardCharsets;

/*
下面是一个示例，展示如何使用转换流读取 GBK 编码的文件并将其内容转换为 UTF-8 编码写入到另一个文件中：
 */

public class StreamConversionDemo {
    public static void main(String[] args) {
        // 1. 将GBK编码的字节流转换为字符流读取
        String sourceFilePath = "source_gbk.txt";

        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             InputStreamReader isr = new InputStreamReader(fis, "GBK");
             BufferedReader reader = new BufferedReader(isr)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 将字符流转换为UTF-8编码的字节流写入
        String destFilePath = "dest_utf8.txt";

        try (FileOutputStream fos = new FileOutputStream(destFilePath);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)) {

            String content = "Hello, this is a text content.";
            writer.write(content);

            System.out.println("内容写入完成！");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}