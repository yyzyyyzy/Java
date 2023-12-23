package 变量;
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//import java.util.Base64;
//
//public class Main {
//
//    public static void main(String[] args) {
//        try {
//            String plainText = "Qwer1234!";
//            String key = "Czzy_01#2020ITOA"; // 16 字节的密钥
//
//            byte[] encryptedBytes = encrypt(plainText, key);
//            String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
//            System.out.println("Encrypted: " + encryptedBase64);
//
//            String decryptedText = decrypt(encryptedBytes, key);
//            System.out.println("Decrypted: " + decryptedText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static byte[] encrypt(String plainText, String key) throws Exception {
//        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
//        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//        return cipher.doFinal(plainText.getBytes());
//    }
//
//    public static String decrypt(byte[] cipherText, String key) throws Exception {
//        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
//        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//        cipher.init(Cipher.DECRYPT_MODE, secretKey);
//        byte[] decryptedBytes = cipher.doFinal(cipherText);
//        return new String(decryptedBytes);
//    }
//}


public class VarDemo {
    public static void main(String[] args) {
        // int
        int a = 10;
        System.out.println(a);

        // byte
        byte b = 127;
        System.out.println(b);

        // short
        short s = 20;
        System.out.println(s);

        // long:需要加一个L作为后缀
        long l = 123456789L;
        System.out.println(l);

        // float:需要加一个F作为后缀
        float f = 3.14F;
        System.out.println(f);

        // double
        double d = 2.71828;
        System.out.println(d);

        // char
        char c = 'A';
        System.out.println(c);

        // boolean
        boolean bool = true;
        System.out.println(bool);
    }
}
