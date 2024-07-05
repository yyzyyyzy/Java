import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientMutiDemo {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // 创建一个 DatagramSocket
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            int serverPort = 3333;

            String[] messages = {
                    "客户端消息1",
                    "客户端消息2",
                    "客户端消息3",
            };

            for (String message : messages) {
                // 发送消息给服务器
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                socket.send(sendPacket);

                System.out.println("发送消息: " + message);

                // 接收服务器的响应
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("收到服务器响应: " + responseMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
