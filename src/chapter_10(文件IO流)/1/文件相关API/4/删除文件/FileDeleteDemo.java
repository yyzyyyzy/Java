import java.io.File;

public class FileDeleteDemo {
    public static void main(String[] args) {
        String directoryPath = "path/to/your/directory";
        deleteDirectory(new File(directoryPath));
    }

    public static void deleteDirectory(File directory) {
        if (!directory.exists()) {
            return;
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归删除子目录
                    deleteDirectory(file);
                } else {
                    // 删除文件
                    file.delete();
                }
            }
        }
        directory.delete(); // 删除空目录
    }
}

