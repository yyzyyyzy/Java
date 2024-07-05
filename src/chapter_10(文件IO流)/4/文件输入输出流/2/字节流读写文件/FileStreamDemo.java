import java.io.*;

public class FileStreamDemo {
    public static void main(String[] args) {
        String data = "This is a test.";
        String filePath = "example.txt";

        // 写入文件
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data.getBytes());
            System.out.println("Data written to file using FileOutputStream.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取文件
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int content;
            // fis.read() 从输入流中读取一个字节，并将其返回。如果到达文件末尾，read() 方法会返回 -1
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
            System.out.println("\nData read from file using FileInputStream.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}