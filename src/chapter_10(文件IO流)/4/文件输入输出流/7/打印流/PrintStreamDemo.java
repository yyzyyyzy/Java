/*
    PrintStream 主要用于输出字节数据，通常用于写入二进制文件或网络流。
    PrintWriter 主要用于输出字符数据，通常用于写入文本文件或网络连接。
 */

import java.io.*;

public class PrintStreamDemo {
    public static void main(String[] args) {
        String filePath = "printstream_output.txt";

        // 1.PrintStream(OutputStream out) 通常用于将格式化的输出发送到控制台或文件
        try (FileOutputStream fos = new FileOutputStream(filePath);
             PrintStream ps = new PrintStream(fos)) {
            ps.println("Hello, PrintStream with OutputStream!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2.PrintStream(OutputStream out, boolean autoFlush) 其输出流为指定的OutputStream，并指定是否自动刷新输出缓冲区
        try (FileOutputStream fos = new FileOutputStream("output.txt");
             PrintStream ps = new PrintStream(fos, true)) {
            ps.println("Hello, PrintStream with autoFlush!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3.PrintStream(OutputStream out, boolean autoFlush, String encoding) 其输出流为指定的OutputStream，并指定是否自动刷新输出缓冲区和字符编码
        try (FileOutputStream fos = new FileOutputStream("output.txt");
             PrintStream ps = new PrintStream(fos, true, "UTF-8")) {
            ps.println("Hello, PrintStream with encoding!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4.PrintStream(String fileName) 其输出流为指定的文件，如果文件不存在，会创建一个新文件；如果文件存在，会覆盖文件内容
        try (PrintStream ps = new PrintStream("output.txt")) {
            ps.println("Hello, PrintStream with file name!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5.PrintStream(String fileName, String csn) 其输出流为指定的文件，并指定字符编码
        try (PrintStream ps = new PrintStream("output.txt", "UTF-8")) {
            ps.println("Hello, PrintStream with file name and encoding!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}