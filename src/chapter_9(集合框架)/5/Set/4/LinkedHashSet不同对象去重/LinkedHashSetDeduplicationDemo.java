import java.util.LinkedHashSet;
import java.util.Objects;

class LinkedHashSetDeduplication {
    private String name;
    private int age;

    public LinkedHashSetDeduplication(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 重写 hashCode 方法
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // 重写 equals 方法
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedHashSetDeduplication person = (LinkedHashSetDeduplication) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class LinkedHashSetDeduplicationDemo {
    public static void main(String[] args) {
        LinkedHashSet<LinkedHashSetDeduplication> set = new LinkedHashSet<>();
        LinkedHashSetDeduplication p1 = new LinkedHashSetDeduplication("Alice", 30);
        LinkedHashSetDeduplication p2 = new LinkedHashSetDeduplication("Bob", 25);
        LinkedHashSetDeduplication p3 = new LinkedHashSetDeduplication("Alice", 30); // 内容与 p1 相同，但不同对象

        set.add(p1);
        set.add(p2);
        set.add(p3); // 由于 p3 与 p1 内容相同，不能添加成功

        System.out.println("LinkedHashSet contents:");
        for (LinkedHashSetDeduplication p : set) {
            System.out.println(p);
        }
    }
}
