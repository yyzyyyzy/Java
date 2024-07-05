import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClientMutiDemo {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            // 连接到服务器
            socket = new Socket("localhost", 3333);
            System.out.println("已连接到服务器");

            // 创建输出流向服务器发送消息
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            // 创建输入流读取服务器的响应消息
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 要发送的消息数组
            String[] messages = {
                    "客户端消息1",
                    "客户端消息2",
                    "客户端消息3",
                    "客户端消息4",
            };

            // 发送消息并接收服务器的响应
            for (String message : messages) {
                out.println(message);
                System.out.println("发送消息: " + message);

                // 读取服务器的响应
                String response = in.readLine();
                System.out.println("服务器响应: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
