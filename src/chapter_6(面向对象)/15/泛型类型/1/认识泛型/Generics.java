import java.util.ArrayList;

public class Generics {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add("java1");
        list.add(1);
        list.add(0.1234);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}