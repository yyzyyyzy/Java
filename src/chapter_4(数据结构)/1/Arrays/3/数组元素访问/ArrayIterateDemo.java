public class ArrayIterateDemo {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        System.out.println(myArray); //直接打印是数组的地址值
        System.out.println(myArray[1]); //此时打印的是数组的真实值

        //遍历整个数组的元素
        for (int x : myArray) {
            System.out.println(x);
        }

        //求数组的最大值
        int num = 0;
        for (int i = 0; i <= myArray.length; i++) {
            if (i > num) {
                num = i;
            }
        }
        System.out.println("数组的最大值为：" + num);

        //数组求和并统计个数
        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            sum += myArray[i];
        }
        System.out.println("数组的元素和为：" + sum);
        System.out.println("数组的总个数为：" + myArray.length);
        
    }
}