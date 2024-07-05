import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerMutiDemo {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // 创建一个 DatagramSocket 在指定端口上监听
                socket = new DatagramSocket(3333);
            byte[] receiveData = new byte[1024];

            System.out.println("服务器已启动，等待客户端消息...");

            while (true) {
                // 创建一个 DatagramPacket 用于接收数据
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // 接收客户端发送的数据
                socket.receive(receivePacket);
                // 将接收到的数据转换为字符串
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("收到消息: " + message);

                // 判断是否为退出消息
                if (message.equals("exit")) {
                    System.out.println("服务器关闭...");
                    break;
                }

                // 向客户端发送响应消息
                String responseMessage = "服务器已收到: " + message;
                byte[] sendData = responseMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
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
