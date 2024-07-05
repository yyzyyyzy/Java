import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HTTPServerDemo {

    public static void main(String[] args) throws IOException {
        // 创建一个HttpServer实例，并绑定到指定的端口
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // 创建一个上下文，绑定路径和处理器
        server.createContext("/", new RootHandler());

        // 启动服务器
        server.start();

        System.out.println("服务器已启动，监听端口 8080");
    }

    // 处理根路径的处理器
    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // 设置响应头
            String response = "Hello, World!";
            exchange.sendResponseHeaders(200, response.length());

            // 向客户端写入响应
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
