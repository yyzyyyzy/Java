import java.io.File;

public class DirectoryDeleteDemo {
    public static void main(String[] args) {
        // 指定文件夹路径
        String dirPath = "exampleDir";
        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            if (directory.delete()) {
                System.out.println("文件夹删除成功: " + directory.getPath());
            } else {
                System.out.println("文件夹删除失败，文件夹可能不为空: " + directory.getPath());
            }
        } else {
            System.out.println("文件夹不存在或不是一个文件夹: " + directory.getPath());
        }
    }
}