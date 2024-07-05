import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/*
    实现一个简单的Java群聊功能，需要一个服务器端和多个客户端，所有客户端都能相互发送和接收消息。
    为了实现群聊，服务器需要管理所有连接的客户端，并将收到的消息广播给所有其他客户端
 */

public class ChatServerDemo {
    private static final int PORT = 3333; // 服务器监听的端口号
    private static Set<ChatServer> clientHandlers = new HashSet<>(); // 存储所有连接的客户端处理器

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // 创建一个ServerSocket来监听指定端口
            serverSocket = new ServerSocket(PORT);
            System.out.println("服务器已启动，等待客户端连接...");

            while (true) {
                // 接受客户端连接
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端已连接：" + clientSocket.getInetAddress());
                // 创建一个新的客户端处理器
                ChatServer clientHandler = new ChatServer(clientSocket);
                // 将客户端处理器添加到集合中
                clientHandlers.add(clientHandler);
                // 启动一个新的线程来处理该客户端的消息
                new Thread(clientHandler).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭服务器套接字
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 广播消息给所有其他客户端
    public static void broadcastMessage(String message, ChatServer sender) {
        for (ChatServer clientHandler : clientHandlers) {
            if (clientHandler != sender) {
                clientHandler.sendMessage(message);
            }
        }
    }

    // 移除客户端处理器
    public static void removeClientHandler(ChatServer clientHandler) {
        clientHandlers.remove(clientHandler);
    }
}

class ChatServer implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;

    public ChatServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            // 创建输出流，用于向客户端发送消息
            this.out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // 创建输入流，用于接收客户端发送的消息
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("收到消息: " + message);
                // 广播消息给其他客户端
                ChatServerDemo.broadcastMessage(message, this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭客户端套接字
                if (clientSocket != null && !clientSocket.isClosed()) {
                    clientSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 从服务器的客户端处理器集合中移除该客户端处理器
            ChatServerDemo.removeClientHandler(this);
        }
    }

    // 发送消息给客户端
    public void sendMessage(String message) {
        out.println(message);
    }
}
