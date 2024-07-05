import java.io.*;

public class BufferedStreamDemo {
    public static void main(String[] args) {
        String sourceFilePath = "source.txt";
        String destFilePath = "dest.txt";

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath))) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("文件拷贝完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}