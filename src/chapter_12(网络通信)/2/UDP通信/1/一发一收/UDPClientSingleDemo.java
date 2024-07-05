import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientSingleDemo {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // 创建一个 DatagramSocket
            socket = new DatagramSocket();
            // 127.0.0.1
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 3333;

            // 定义要发送的消息
            String message = "客户端给服务端发送的第一条消息";
            byte[] sendData = message.getBytes();
            // 创建一个 DatagramPacket 用于发送数据
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            // 发送数据到服务器
            socket.send(sendPacket);

            System.out.println("消息已发送: " + message);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
