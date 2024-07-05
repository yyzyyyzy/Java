import java.io.*;

public class PrintWriterDemo {
    public static void main(String[] args) {
        // 1.PrintWriter(OutputStream out) 其输出流为指定的OutputStream，适用于将字符数据输出到不同类型的输出流，如文件、网络流等
        try (FileOutputStream fos = new FileOutputStream("output.txt");
             PrintWriter pw = new PrintWriter(fos)) {
            pw.println("Hello, PrintWriter with OutputStream!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2.PrintWriter(OutputStream out, boolean autoFlush) 其输出流为指定的OutputStream，并指定是否自动刷新输出缓冲区
        try (FileOutputStream fos = new FileOutputStream("output.txt");
             PrintWriter pw = new PrintWriter(fos, true)) {
            pw.println("Hello, PrintWriter with autoFlush!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3.PrintWriter(Writer out) 其输出流为指定的Writer，适用于将字符数据输出到不同类型的字符流，如StringWriter、FileWriter等
        try (FileWriter fw = new FileWriter("output.txt");
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("Hello, PrintWriter with Writer!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4.PrintWriter(Writer out, boolean autoFlush) 其输出流为指定的Writer，并指定是否自动刷新输出缓冲区
        try (FileWriter fw = new FileWriter("output.txt");
             PrintWriter pw = new PrintWriter(fw, true)) {
            pw.println("Hello, PrintWriter with autoFlush!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5.PrintWriter(String fileName) 其输出流为指定的文件，如果文件不存在，会创建一个新文件；如果文件存在，会覆盖文件内容
        try (PrintWriter pw = new PrintWriter("output.txt")) {
            pw.println("Hello, PrintWriter with file name!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 6,PrintWriter(String fileName, String csn) 创建一个新的PrintWriter，其输出流为指定的文件，并指定字符编码
        try (PrintWriter pw = new PrintWriter("output.txt", "UTF-8")) {
            pw.println("Hello, PrintWriter with file name and encoding!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}