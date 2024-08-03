import java.util.*;
import java.util.stream.Collectors;

public class StreamObjectDemo {
    public static void main(String[] args) {
        // 创建包含 Person 对象的列表
        List<ObjectDemo> people = Arrays.asList(
                new ObjectDemo(1L, "Alice", 30),
                new ObjectDemo(2L, "Bob", 25),
                new ObjectDemo(3L, "Charlie", 35),
                new ObjectDemo(4L, "David", 30),
                new ObjectDemo(5L, "Eve", 40),
                new ObjectDemo(6L, "Frank", 25),
                new ObjectDemo(7L, "Grace", 30)
        );

        // 过滤出年龄大于 30 的人
        List<ObjectDemo> peopleOlderThan30 = people.stream()
                .filter(person -> person.getAge() > 30)
                .collect(Collectors.toList());

        // 将每个人的名字转换为大写
        List<String> upperCaseNames = people.stream()
                .map(person -> person.getName().toUpperCase())
                .collect(Collectors.toList());

        // 按年龄排序（从小到大）
        List<ObjectDemo> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(ObjectDemo::getAge))
                .collect(Collectors.toList());

        // 只保留前 3 个元素
        List<ObjectDemo> firstThree = people.stream()
                .limit(3)
                .collect(Collectors.toList());

        // 跳过前 3 个元素
        List<ObjectDemo> skippedFirstThree = people.stream()
                .skip(3)
                .collect(Collectors.toList());

        // 计算所有人的年龄总和
        int totalAge = people.stream()
                .mapToInt(ObjectDemo::getAge)
                .sum();

        // 统计每个年龄的人员数量（分组）
        Map<Integer, Long> ageCount = people.stream()
                .collect(Collectors.groupingBy(ObjectDemo::getAge, Collectors.counting()));

        // 扁平化示例（假设有多个班级，每个班级有多个学生）
        List<List<ObjectDemo>> classes = Arrays.asList(
                Arrays.asList(new ObjectDemo(1L, "Alice", 30), new ObjectDemo(2L, "Bob", 25)),
                Arrays.asList(new ObjectDemo(3L, "Charlie", 35), new ObjectDemo(4L, "David", 30)),
                Arrays.asList(new ObjectDemo(5L, "Eve", 40), new ObjectDemo(6L, "Frank", 25))
        );

        // 扁平化所有班级中的学生
        List<ObjectDemo> allStudents = classes.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        // 输出结果
        System.out.println("People older than 30: " + peopleOlderThan30);
        System.out.println("Uppercase names: " + upperCaseNames);
        System.out.println("Sorted by age: " + sortedByAge);
        System.out.println("First three people: " + firstThree);
        System.out.println("Skipped first three people: " + skippedFirstThree);
        System.out.println("Total age: " + totalAge);
        System.out.println("Age count: " + ageCount);
        System.out.println("All students: " + allStudents);
    }
}

class ObjectDemo {
    private Long id;
    private String name;
    private int age;

    public ObjectDemo(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}

