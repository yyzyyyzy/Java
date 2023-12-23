public class FunctionPassByValueDemo {
    public static void main(String[] args) {
        int x = 100;
        changeValue(x);
        System.out.println("x = " + x);  // 输出：x = 100

        int[] nums = {1, 2, 3};
        changeArray(nums);
        System.out.println("nums[0] = " + nums[0]);  // 输出：nums[0] = 100
    }

    //方法的值传递
    public static void changeValue(int value) {
        value = 200;
    }

    //方法的引用传递
    public static void changeArray(int[] arr) {
        arr[0] = 100;
    }
}