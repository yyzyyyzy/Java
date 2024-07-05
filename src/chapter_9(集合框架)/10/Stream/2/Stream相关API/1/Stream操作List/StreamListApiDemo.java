import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListApiDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2, 2, 9, 1, 3);
        List<String> words = Arrays.asList("hello", "world", "java", "stream");
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        // 过滤出偶数
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // 将每个字符串转换为大写
        List<String> upperCaseWords = words.stream()
                //stream.map用于对流中的每个元素应用一个函数，然后返回一个新的流，新流中包含了应用函数后的结果
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // 去除重复元素
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());


        // 对数字进行排序
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        // 只保留前 5 个元素
        List<Integer> limitedNumbers = numbers.stream()
                .limit(5)
                .collect(Collectors.toList());

        // 跳过前 5 个元素
        List<Integer> skippedNumbers = numbers.stream()
                .skip(5)
                .collect(Collectors.toList());

        // 将多个列表合并为一个列表
        List<Integer> flatList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Uppercase words: " + upperCaseWords);
        System.out.println("Distinct numbers: " + distinctNumbers);
        System.out.println("Sorted numbers: " + sortedNumbers);
        System.out.println("Limited numbers: " + limitedNumbers);
        System.out.println("Skipped numbers: " + skippedNumbers);
        System.out.println("Flattened list: " + flatList);
    }
}