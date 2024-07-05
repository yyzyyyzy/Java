import java.io.File;

public class DirectoryListDemo {
    public static void main(String[] args) {
        // 指定文件夹路径
        String dirPath = "D:\\桌面文件\\奇安信——工作记录\\AllTime——代码——nac代码\\javaTest\\src\\chapter_5(方法)";
        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            // 列出文件和子目录名称
            String[] contents = directory.list();
            System.out.println("文件夹内容 (名称):");
            for (String content : contents) {
                System.out.println(content);
            }

            // 列出文件和子目录对象
            File[] files = directory.listFiles();
            System.out.println("文件夹内容 (对象):");
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(file.getName() + " (Directory)");
                } else {
                    System.out.println(file.getName() + " (File)");
                }
            }
        } else {
            System.out.println("文件夹不存在或不是一个文件夹: " + directory.getPath());
        }
    }
}