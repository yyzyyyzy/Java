import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class runtimeDemo {
    public static void main(String[] args) {
        //1. 获取 Java 虚拟机的可用处理器数量
        Runtime runtime1 = Runtime.getRuntime();
        int processors = runtime1.availableProcessors();
        System.out.println("可用处理器数量：" + processors);

        //2. 获取最大内存
        Runtime runtime2 = Runtime.getRuntime();
        long maxMemory = runtime2.maxMemory();
        System.out.println("最大内存：" + maxMemory / (1024 * 1024) + " MB");

        //3. 获取空闲内存
        Runtime runtime3 = Runtime.getRuntime();
        long freeMemory = runtime3.freeMemory();
        System.out.println("空闲内存：" + freeMemory / (1024 * 1024) + " MB");

        //4. 获取内存大小
        Runtime runtime4 = Runtime.getRuntime();
        long totalMemory = runtime4.totalMemory();
        System.out.println("内存大小：" + totalMemory / (1024 * 1024) + " MB");

        //5. 执行外部命令
        try {
            // 获取Runtime实例
            Runtime runtime = Runtime.getRuntime();
            // 执行Windows的dir命令
            Process process = runtime.exec("cmd.exe /c dir");
            // 读取命令的输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            // 等待命令执行结束
            int exitCode = process.waitFor();
            System.out.println("命令执行结束，退出码：" + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}