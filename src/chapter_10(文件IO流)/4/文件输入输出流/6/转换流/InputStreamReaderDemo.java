import java.io.*;

/*
    处理不同操作系统和环境的数据：在读取和写入文件时，
    不同的操作系统和环境可能使用不同的字符集，使用转换流可以方便地根据需要进行字符编码和解码。
 */


public class InputStreamReaderDemo {
    public static void main(String[] args) {

        // 1. 将字节流转换为字符流(InputStreamReader)
        // 处理文本文件：将字节流（如 FileInputStream）转换为字符流（如 InputStreamReader）用于读取文本文件，
        // 这样可以方便地按行或按字符读取文件内容，同时能够指定字符集解决编码问题。
        String sourceFilePath = "source.txt";

        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader reader = new BufferedReader(isr)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        // 2. 将字符流转换为字节流(OutputStreamWriter)
        // 处理文本数据的输出：将字符流（如 FileWriter）转换为字节流（如 FileOutputStream）用于将字符数据写入文件，
        // 可以指定字符集以确保文件的编码正确性。
        String destFilePath = "dest.txt";

        try (FileWriter fw = new FileWriter(destFilePath);
             BufferedWriter writer = new BufferedWriter(fw)) {

            String content = "Hello, this is a text content.";
            writer.write(content);

            System.out.println("内容写入完成！");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
