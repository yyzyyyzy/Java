import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            // 获取本地主机名和地址
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("本地主机名: " + localHost.getHostName());
            System.out.println("本地IP地址: " + localHost.getHostAddress());

            // 根据主机名获取 InetAddress
            InetAddress address = InetAddress.getByName("www.example.com");
            System.out.println("www.example.com 主机名: " + address.getHostName());
            System.out.println("www.example.com IP地址: " + address.getHostAddress());

            // 根据多个主机名获取 InetAddress 数组
            InetAddress[] addresses = InetAddress.getAllByName("www.example.com");
            System.out.println("www.example.com 所有IP地址:");
            for (InetAddress addr : addresses) {
                System.out.println(addr.getHostAddress());
            }

            // 判断地址是否可达
            boolean reachable = address.isReachable(5000); // 超时时间为 5000 毫秒
            System.out.println("www.example.com 是否可达: " + reachable);

            // 判断是否为本地地址
            boolean isLoopback = address.isLoopbackAddress();
            System.out.println("www.example.com 是否为本地地址: " + isLoopback);

            // 获取广播地址
            boolean isMC = address.isMulticastAddress();
            System.out.println("www.example.com 是否为广播地址: " + isMC);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
