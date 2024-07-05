import java.io.File;

public class DirectoryRecursiveDeleteDemo {
    public static void main(String[] args) {
        // 指定文件夹路径
        String dirPath = "exampleDir";
        File directory = new File(dirPath);

        if (deleteDirectory(directory)) {
            System.out.println("文件夹及其内容删除成功: " + directory.getPath());
        } else {
            System.out.println("文件夹删除失败: " + directory.getPath());
        }
    }

    public static boolean deleteDirectory(File directory) {
        if (!directory.exists()) {
            return false;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }

        return directory.delete();
    }
}