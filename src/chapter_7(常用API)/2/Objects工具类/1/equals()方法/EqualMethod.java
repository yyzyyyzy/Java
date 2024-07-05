import java.util.Objects;

public class EqualMethod {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "null";
        System.out.println(Objects.equals(s1, s2));
    }
}