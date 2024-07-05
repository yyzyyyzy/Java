import java.io.File;

public class DirectoryGetInfoDemo {
    public static void main(String[] args) {
        // 指定文件夹路径
        String dirPath = "exampleDir";
        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            // 获取文件夹信息
            System.out.println("文件夹名称: " + directory.getName());
            System.out.println("文件夹路径: " + directory.getPath());
            System.out.println("文件夹绝对路径: " + directory.getAbsolutePath());
            System.out.println("是否是文件夹: " + directory.isDirectory());
            System.out.println("文件夹大小: " + directory.length() + " bytes");
            System.out.println("最后修改时间: " + directory.lastModified());
        } else {
            System.out.println("文件夹不存在或不是一个文件夹: " + directory.getPath());
        }
    }
}