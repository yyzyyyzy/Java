import java.util.HashSet;
import java.util.Objects;

class HashSetDeduplication {
    private String name;
    private int age;

    public HashSetDeduplication(String name, int age) {
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
        HashSetDeduplication person = (HashSetDeduplication) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class HashSetDeduplicationDemo {
    public static void main(String[] args) {
        HashSet<HashSetDeduplication> set = new HashSet<>();
        HashSetDeduplication p1 = new HashSetDeduplication("Alice", 30);
        HashSetDeduplication p2 = new HashSetDeduplication("Bob", 25);
        HashSetDeduplication p3 = new HashSetDeduplication("Alice", 30); // 内容与 p1 相同，但不同对象

        set.add(p1);
        set.add(p2);
        set.add(p3); // 由于 p3 与 p1 内容相同，不能添加成功

        System.out.println("HashSet contents:");
        for (HashSetDeduplication p : set) {
            System.out.println(p);
        }
    }
}