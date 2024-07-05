import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class FileTraverseDemo {
    public static void main(String[] args) {
        // 替换为你要遍历的文件夹路径
        String folderPath = "path/to/your/folder";
        File folder = new File(folderPath);

        // 遍历文件夹
        traverseFolder(folder);
    }

    public static void traverseFolder(File folder) {
        if (folder.isDirectory()) {
            System.out.println("Folder: " + folder.getAbsolutePath());

            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // 递归调用自身，处理子目录
                        traverseFolder(file);
                    } else {
                        System.out.println("File: " + file.getName());
                        // 在这里可以添加处理文件的逻辑
                    }
                }
            }
        } else {
            System.out.println("Invalid folder path.");
        }
    }
}