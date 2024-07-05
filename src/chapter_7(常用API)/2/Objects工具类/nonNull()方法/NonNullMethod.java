import java.util.Objects;

public class NonNullMethod {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "null";
        System.out.println(Objects.nonNull(s1));
        System.out.println(Objects.nonNull(s2));
    }
}