import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr1 = {9, 1, 2, 4, 3, 5};
        int[] arr2 = {1, 2, 3};
        //toString() 方法： 打印数组的内容
        System.out.println("返回的数组：" + Arrays.toString(arr1)); // 输出：[9, 1, 2, 4, 3, 5]

        //sort() 方法： 对数组进行排序。
        Arrays.sort(arr1);
        System.out.println("排序后的数组：" + Arrays.toString(arr1)); // 输出：[1, 2, 3, 4, 5, 9]

        //parallelSort() 方法： 并行排序数组（适用于大型数组）
        Arrays.parallelSort(arr1);
        System.out.println("并行排序后的数组：" + Arrays.toString(arr1));

        //equals() 方法： 比较两个数组是否相等。
        boolean isEqual = Arrays.equals(arr1, arr2);
        System.out.println("数组是否相等：" + isEqual); // 输出：false

        //binarySearch() 方法： 对已排序的数组进行二分查找。
        int index = Arrays.binarySearch(arr1, 3);
        System.out.println("元素 3 在数组中的索引：" + index); // 输出：2

        //fill() 方法： 使用指定值填充数组。
        Arrays.fill(arr1, 10);
        System.out.println("填充后的数组：" + Arrays.toString(arr1)); // 输出：[10, 10, 10, 10, 10, 10]

        //copyOf() 方法： 复制数组的一部分或整个数组。
        int[] copy = Arrays.copyOf(arr1, arr1.length);
        System.out.println("复制后的数组：" + Arrays.toString(copy)); // 输出：[10, 10, 10, 10, 10, 10]
    }
}