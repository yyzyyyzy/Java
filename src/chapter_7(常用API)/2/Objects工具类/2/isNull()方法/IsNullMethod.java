import java.util.Objects;

public class IsNullMethod {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "null";
        System.out.println(Objects.isNull(s1));
        System.out.println(Objects.isNull(s2));
    }
}