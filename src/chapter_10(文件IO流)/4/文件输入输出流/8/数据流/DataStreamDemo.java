import java.io.*;

public class DataStreamDemo {
    public static void main(String[] args) {
        String fileName = "data.dat";

        // DataInputStream 和 DataOutputStream 扩展了普通流，使其能够直接处理基本数据类型和字符串。
        // 它们提供了读写这些类型的便捷方法，而无需手动进行字节操作。

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // 写入各种基本数据类型
            dos.writeInt(123);        // 写入整数
            dos.writeDouble(456.789); // 写入双精度浮点数
            dos.writeBoolean(true);   // 写入布尔值
            dos.writeUTF("Hello");    // 写入UTF字符串

            System.out.println("数据写入完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            // 读取各种基本数据类型
            int intValue = dis.readInt();           // 读取整数
            double doubleValue = dis.readDouble();  // 读取双精度浮点数
            boolean booleanValue = dis.readBoolean(); // 读取布尔值
            String stringValue = dis.readUTF();     // 读取UTF字符串

            System.out.println("从文件中读取的数据:");
            System.out.println("整数: " + intValue);
            System.out.println("双精度浮点数: " + doubleValue);
            System.out.println("布尔值: " + booleanValue);
            System.out.println("字符串: " + stringValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}