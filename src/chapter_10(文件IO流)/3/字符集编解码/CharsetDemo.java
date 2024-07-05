import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CharsetDemo {
    public static void main(String[] args) {
        // 获取默认字符集
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("Default Charset: " + defaultCharset);

        // 获取特定字符集
        Charset utf8Charset = StandardCharsets.UTF_8;
        System.out.println("UTF-8 Charset: " + utf8Charset);

        // 编码和解码示例
        String originalString = "Hello, 你好!";
        System.out.println("Original String: " + originalString);

        // 编码为 UTF-8 字节
        byte[] encodedBytes = originalString.getBytes(StandardCharsets.UTF_8);
        System.out.println("Encoded Bytes (UTF-8): " + new String(encodedBytes, StandardCharsets.ISO_8859_1));

        // 解码 UTF-8 字节
        String decodedString = new String(encodedBytes, StandardCharsets.UTF_8);
        System.out.println("Decoded String (UTF-8): " + decodedString);

        // Base64 编码和解码示例
        String base64Encoded = Base64.getEncoder().encodeToString(originalString.getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 Encoded String: " + base64Encoded);

        byte[] base64DecodedBytes = Base64.getDecoder().decode(base64Encoded);
        String base64DecodedString = new String(base64DecodedBytes, StandardCharsets.UTF_8);
        System.out.println("Base64 Decoded String: " + base64DecodedString);

        // URL 编码
        String urlEncoded = URLEncoder.encode(originalString, StandardCharsets.UTF_8);
        System.out.println("Encoded URL: " + urlEncoded);

        // URL 解码
        String urlDecoded = URLDecoder.decode(urlEncoded, StandardCharsets.UTF_8);
        System.out.println("Decoded URL: " + urlDecoded);
    }
}
