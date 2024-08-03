public class TernaryOperatorDemo {
    public static void main(String[] args) {
        // 示例1：使用三元运算符找出最大值
        int a = 20;
        int b = 15;
        int c = 25;

        int max = (a > b) ? (a > c ? a : c) : (b > c ? b : c);
        System.out.println("The maximum value is: " + max);

        // 示例2：使用三元运算符判断学生成绩
        int score = 82;
        String grade = (score >= 90) ? "A" :
                (score >= 80) ? "B" :
                        (score >= 70) ? "C" :
                                (score >= 60) ? "D" : "F";
        System.out.println("The grade is: " + grade);

        // 示例3：使用三元运算符判断字符串是否为空
        String input = "Hello, World!";
        String message = (input.isEmpty()) ? "Input is empty" : "Input is not empty";
        System.out.println(message);
    }
}
