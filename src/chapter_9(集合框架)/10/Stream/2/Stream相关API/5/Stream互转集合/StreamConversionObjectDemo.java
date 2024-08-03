import java.util.*;
import java.util.stream.Collectors;

public class StreamConversionObjectDemo {
    public static void main(String[] args) {
        // 创建包含 ConversionDemo 对象的列表
        List<ConversionObjectDemo> peopleList = Arrays.asList(
                new ConversionObjectDemo(1L, "Alice", 30),
                new ConversionObjectDemo(2L, "Bob", 25),
                new ConversionObjectDemo(3L, "Charlie", 35),
                new ConversionObjectDemo(4L, "David", 30),
                new ConversionObjectDemo(5L, "Eve", 40)
        );

        // 从 List 转换为 Set (去重)
        Set<ConversionObjectDemo> peopleSet = peopleList.stream()
                .collect(Collectors.toSet());

        // 从 Set 转换为 List
        List<ConversionObjectDemo> listFromSet = peopleSet.stream()
                .collect(Collectors.toList());

        // 从 List 转换为 Map (以 ID 为键，ConversionDemo 为值)
        Map<Long, ConversionObjectDemo> peopleMapById = peopleList.stream()
                .collect(Collectors.toMap(ConversionObjectDemo::getId, person -> person));

        // 从 Map 转换为 List (只取 Map 的值)
        List<ConversionObjectDemo> listFromMap = peopleMapById.values().stream()
                .collect(Collectors.toList());

        // 从 List 转换为 Map (以年龄为键，值为包含该年龄的 ConversionDemo 的 List)
        Map<Integer, List<ConversionObjectDemo>> peopleByAge = peopleList.stream()
                .collect(Collectors.groupingBy(ConversionObjectDemo::getAge));

        // 从 Map 转换为 Set (扁平化所有年龄的 ConversionDemo)
        Set<ConversionObjectDemo> flatSetFromMap = peopleByAge.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toSet());

        // 从 Set 转换为 Map (以名字为键，值为 ConversionDemo 对象)
        Map<String, ConversionObjectDemo> setToMapByName = peopleSet.stream()
                .collect(Collectors.toMap(ConversionObjectDemo::getName, person -> person));

        // 从 Map 转换为 Set (获取 Map 的键)
        Set<String> keysFromMap = setToMapByName.keySet();

        // 从 Map 转换为 List (只取 Map 的值)
        List<ConversionObjectDemo> personsFromMap = setToMapByName.values().stream()
                .collect(Collectors.toList());

        // 打印所有转换的结果
        System.out.println("Original List: " + peopleList);
        System.out.println("List to Set: " + peopleSet);
        System.out.println("Set to List: " + listFromSet);
        System.out.println("List to Map by ID: " + peopleMapById);
        System.out.println("Map to List (values): " + listFromMap);
        System.out.println("List to Map by Age: " + peopleByAge);
        System.out.println("Map to Set (flattened): " + flatSetFromMap);
        System.out.println("Set to Map by Name: " + setToMapByName);
        System.out.println("Map to Set of Keys: " + keysFromMap);
        System.out.println("Map to List (values): " + personsFromMap);
    }
}

class ConversionObjectDemo {
    private Long id;
    private String name;
    private int age;

    public ConversionObjectDemo(Long id, String name, int age) {
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
        return "ConversionDemo{id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
