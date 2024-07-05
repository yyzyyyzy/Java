import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

/*
    这些示例展示了Apache Commons IO库的一些常用功能，简化了文件和流的操作。
    通过这些示例，你可以更方便地进行文件复制、读取、写入、流处理和文件名操作等任务
 */

public class CommonsIODemo {
    public static void main(String[] args) {
        //1. FileUtils
        //1.1 复制文件
        File file = new File("example.txt");
        File source = new File("source.txt");
        File destination = new File("destination.txt");

        String data = "Hello, World!";

        try {
            FileUtils.copyFile(source, destination);
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //1.2 读取文件内容到字符串
        try {
            String content = FileUtils.readFileToString(file, "UTF-8");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //1.3 写入字符串到文件
        try {
            FileUtils.writeStringToFile(file, data, "UTF-8");
            System.out.println("Data written to file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2. IOUtils
        //2.1 将输入流转换为字符串
        try (InputStream inputStream = new FileInputStream("example.txt")) {
            String content = IOUtils.toString(inputStream, "UTF-8");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.2 复制输入流到输出流
        try (InputStream inputStream = new FileInputStream("source.txt");
             OutputStream outputStream = new FileOutputStream("destination.txt")) {

            IOUtils.copy(inputStream, outputStream);
            System.out.println("Stream copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3. FilenameUtils
        //3.1 获取文件扩展名
        String fileName = "example.txt";
        String extension = FilenameUtils.getExtension(fileName);
        System.out.println("File extension: " + extension);

        //3.2 获取文件的基本名称（不含扩展名）
        String baseName = FilenameUtils.getBaseName(fileName);
        System.out.println("Base name: " + baseName);

        //4. FileUtils - 目录操作
        //4.1 复制目录
        File sourceDir = new File("sourceDir");
        File destinationDir = new File("destinationDir");

        try {
            FileUtils.copyDirectory(sourceDir, destinationDir);
            System.out.println("Directory copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //4.2 删除目录
        File directory = new File("directoryToDelete");

        try {
            FileUtils.deleteDirectory(directory);
            System.out.println("Directory deleted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}