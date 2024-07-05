import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo {
    public static void main(String[] args) {
        // 源文件路径
        String sourceFilePath = "source.txt";
        // 目标文件路径
        String destFilePath = "dest.txt";

        // 创建FileInputStream和FileOutputStream对象
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destFilePath)) {

            // 创建缓冲区
            byte[] buffer = new byte[1024];
            int length;

            // 读取源文件内容并写入目标文件
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            System.out.println("文件拷贝完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}