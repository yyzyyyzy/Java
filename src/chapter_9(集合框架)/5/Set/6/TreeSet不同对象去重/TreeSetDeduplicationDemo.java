import java.util.Comparator;
import java.util.TreeSet;

/*
HashSet 的去重机制：
    依赖于 hashCode 和 equals 方法：HashSet 内部使用哈希表来存储元素，
    它通过元素的 hashCode 值来确定存储位置，并通过 equals 方法来判断元素是否相同。
    当你向 HashSet 添加一个元素时，HashSet 会首先计算这个元素的 hashCode。
    然后，它会检查哈希表中是否已经存在相同 hashCode 的元素链表或树。
    如果存在相同 hashCode 的元素链表或树，它会调用这些元素的 equals 方法来逐个比较确定是否真正相同。
    如果元素的 hashCode 相同但 equals 方法返回 false，HashSet 会将该元素视为不同元素而存储。

TreeSet 的去重机制：
    依赖于 compareTo 方法或 Comparator：TreeSet 使用红黑树来存储元素，
    并且要求元素类实现 Comparable 接口或者在构造 TreeSet 时提供一个 Comparator。
    当你向 TreeSet 添加一个元素时，它会根据元素的比较方法（compareTo 方法或者提供的 Comparator）来确定元素的插入位置。
    如果两个元素通过比较方法认为相等（即返回值为 0），TreeSet 会将新元素视为已存在的元素而不会重复插入。
 */

class TreeSetDeduplication1 {
    private String name;
    private int age;

    public TreeSetDeduplication1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

//方法一：实现 Comparable 接口
//如果你的对象是自定义类，并且希望通过对象自身的某种属性进行排序，
//可以让该类实现 Comparable 接口，并重写 compareTo 方法。
class TreeSetDeduplication2 implements Comparable<TreeSetDeduplication2> {
    private String name;
    private int age;

    public TreeSetDeduplication2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 实现 compareTo 方法，根据 name 字段排序
    @Override
    public int compareTo(TreeSetDeduplication2 other) {
//        return this.name.compareTo(other.name);
        //根据 age 字段排序
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class TreeSetDeduplicationDemo {
    public static void main(String[] args) {
        TreeSet<TreeSetDeduplication2> treeSet2 = new TreeSet<>();
        //方法二：使用 Comparator 自定义排序规则
        //如果你希望在不修改类本身的情况下定义多种排序方式，可以使用 Comparator 接口来提供自定义的排序逻辑。
        //根据 name 字段排序
        TreeSet<TreeSetDeduplication1> treeSet1 = new TreeSet<>(Comparator.comparing(TreeSetDeduplication1::getName));
        //根据 age 字段排序
        //TreeSet<TreeSetSort1> treeSet1 = new TreeSet<>(Comparator.comparing(TreeSetSort1::getAge));

        treeSet1.add(new TreeSetDeduplication1("Alice", 25));
        treeSet1.add(new TreeSetDeduplication1("Bob", 30));
        treeSet1.add(new TreeSetDeduplication1("Alice", 22)); // 这个对象内容与第一个Alice对象相同

        treeSet2.add(new TreeSetDeduplication2("Alice", 25));
        treeSet2.add(new TreeSetDeduplication2("Bob", 30));
        treeSet2.add(new TreeSetDeduplication2("Alice", 22)); // 这个对象内容与第一个Alice对象相同

        System.out.println("TreeSet sorted by name: " + treeSet1);
        System.out.println("TreeSet sorted by name: " + treeSet2);
    }
}

