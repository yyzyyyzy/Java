import java.io.File;

public class DirectoryCreateDemo {
    public static void main(String[] args) {
        // 使用 mkdir() 或 mkdirs() 方法创建单个或多个层级的文件夹。
        // 指定文件夹路径
        String dirPath = "exampleDir/subDir";
        File directory = new File(dirPath);

        // 创建单个层级的文件夹
        if (directory.mkdir()) {
            System.out.println("单个文件夹创建成功: " + directory.getPath());
        } else {
            System.out.println("单个文件夹创建失败或已存在: " + directory.getPath());
        }

        // 创建多层级的文件夹
        if (directory.mkdirs()) {
            System.out.println("多层级文件夹创建成功: " + directory.getPath());
        } else {
            System.out.println("多层级文件夹创建失败或已存在: " + directory.getPath());
        }
    }
}