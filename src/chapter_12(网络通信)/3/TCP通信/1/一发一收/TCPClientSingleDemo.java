import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClientSingleDemo {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            // 连接到服务器
            socket = new Socket("localhost", 3333);
            System.out.println("已连接到服务器");

            // 创建输出流向服务器发送消息
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            out.println("客户端给服务端发送的第一条消息");

            // 创建输入流读取服务器的响应消息
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = in.readLine();
            System.out.println("服务器响应: " + response);

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
