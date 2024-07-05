import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamSetApiDemo {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(5, 3, 8, 1, 9, 2, 2, 9, 1, 3));
        Set<String> words = new HashSet<>(Arrays.asList("hello", "world", "java", "stream"));
        Set<Set<Integer>> setOfSets = new HashSet<>(Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3)),
                new HashSet<>(Arrays.asList(4, 5, 6)),
                new HashSet<>(Arrays.asList(7, 8, 9))
        ));

        // 过滤出偶数
        Set<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toSet());

        // 将每个字符串转换为大写
        Set<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        // 去除重复元素：对于 Set 来说，去重操作本身是冗余的，因为 Set 已经保证了元素的唯一性

        // 对数字进行排序（注意，Set 本身无序，排序后的结果可以用 List 表示）
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        // 只保留前 5 个元素
        Set<Integer> limitedNumbers = numbers.stream()
                .limit(5)
                .collect(Collectors.toSet());

        // 跳过前 5 个元素
        Set<Integer> skippedNumbers = numbers.stream()
                .skip(5)
                .collect(Collectors.toSet());

        // 将多个集合合并为一个集合
        Set<Integer> flatSet = setOfSets.stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Uppercase words: " + upperCaseWords);
        System.out.println("Sorted numbers: " + sortedNumbers);
        System.out.println("Limited numbers: " + limitedNumbers);
        System.out.println("Skipped numbers: " + skippedNumbers);
        System.out.println("Flattened set: " + flatSet);
    }
}