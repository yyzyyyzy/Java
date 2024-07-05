import java.util.Objects;

public class EqualsMethod {
    private String name;
    private int age;

    public EqualsMethod(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        EqualsMethod person1 = new EqualsMethod("Alice", 30);
        EqualsMethod person2 = new EqualsMethod("Alice", 30);
        // 调用equals方法
        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode() == person2.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EqualsMethod person = (EqualsMethod) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
