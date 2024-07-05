import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileGetInfoDemo {

    public static void main(String[] args) throws IOException {
        // 替换为你的文件路径
        String filePath = "example.txt";
        File file = new File(filePath);
        try {
            Path path = Paths.get(filePath);
            String fileType = Files.probeContentType(path);

            // 打印文件类型
            System.out.println("File type: " + fileType);
            // 打印文件信息
            System.out.println("Is File: " + file.isFile());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("File name: " + file.getName());
            System.out.println("File path: " + file.getPath());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("Last modified time: " + file.lastModified());
            System.out.println("File absolute path: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to determine file type: " + e.getMessage());
        }
    }
}
