package private关键字;

public class PersonTest {
    public static void main(String[] args) {
        private关键字.Person p1 = new private关键字.Person();

        p1.setName("lzk");
        p1.setAge(18);
        System.out.println(p1.getName());
        System.out.println(p1.getAge());
    }
}