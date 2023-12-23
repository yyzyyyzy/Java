public class WhileDemo {
    public static void main(String[] args) {
        //计算一张厚度为0.1的纸，需要折多少次可以比珠穆朗玛峰的高度（8844430）还要大？
        double height = 8844430;
        double paper = 0.1;
        int count = 0;
        while (paper < height) {
            paper *= 2;
            count++;
        }
        System.out.println("折纸的次数" + count);

        //无限while循环——while(true)
        while (true) {
            System.out.println("hello lzk");
        }
    }
}