import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerMutiDemo {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            // 创建一个 ServerSocket 在指定端口上监听
            serverSocket = new ServerSocket(3333);
            System.out.println("服务器已启动，等待客户端连接...");

            // 接受客户端连接
            clientSocket = serverSocket.accept();
            System.out.println("客户端已连接：" + clientSocket.getInetAddress());

            // 创建输入流读取客户端发送的消息
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // 创建输出流向客户端发送响应消息
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("收到消息: " + message);

                // 判断是否为退出消息
                if (message.equals("exit")) {
                    System.out.println("服务器关闭...");
                    break;
                }

                // 向客户端发送响应消息
                String responseMessage = "服务器已收到: " + message;
                out.println(responseMessage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (clientSocket != null && !clientSocket.isClosed()) {
                    clientSocket.close();
                }
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
