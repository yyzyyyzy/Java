import java.io.*;

public class FileReaderWriterDemo {
    public static void main(String[] args) {
        String data = "This is a test.";
        String filePath = "example.txt";

        // 写入文件
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
            System.out.println("Data written to file using FileWriter.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取文件
        try (FileReader reader = new FileReader(filePath)) {
            int content;
            while ((content = reader.read()) != -1) {
                System.out.print((char) content);
            }
            System.out.println("\nData read from file using FileReader.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}