import java.io.*;

public class BufferedReaderWriterDemo {
    public static void main(String[] args) {
        String sourceFilePath = "source.txt";
        String destFilePath = "dest.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // 写入换行符
            }

            System.out.println("文件拷贝完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}