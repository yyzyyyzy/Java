package 关键字_private;

public class PersonTest {
    public static void main(String[] args) {
        关键字_private.Person p1 = new 关键字_private.Person();

        p1.setName("lzk");
        p1.setAge(18);
        System.out.println(p1.getName());
        System.out.println(p1.getAge());
    }
}