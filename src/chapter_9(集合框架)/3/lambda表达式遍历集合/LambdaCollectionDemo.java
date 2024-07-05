import java.util.*;

public class LambdaCollectionDemo {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");

        // 使用 Lambda 表达式
        fruits.forEach(fruit -> System.out.println(fruit));

        Set<String> animals = new HashSet<>();
        animals.add("cat");
        animals.add("dog");
        animals.add("elephant");

        // 使用 Lambda 表达式
        animals.forEach(animal -> System.out.println(animal));


        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        // 使用 Lambda 表达式
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
}