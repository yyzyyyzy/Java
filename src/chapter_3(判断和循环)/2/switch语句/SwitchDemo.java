public class SwitchDemo {
    public static void main(String[] args) {
        main1();

        int a = 10;
        switch (a) {
            case 100:
                System.out.println("100");
                break;
            case 50:
                System.out.println("50");
                break;
            case 10:
                System.out.println("10");
                break;
            default:
                System.out.println("null");
                break;
        }
    }

    //如果 case 语句块中没有 break 语句时，JVM 并不会顺序输出每一个 case 对应的返回值，而是继续匹配，匹配不成功则返回默认 case。
    //如果 case 语句块中没有 break 语句时，匹配成功后，从当前 case 开始，后续所有 case 的值都会输出。
    //如果后续的 case 语句块有 break 语句则会跳出判断。
    public static void main1() {
        int i = 1;
        switch (i) {
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            default:
                System.out.println("default");
        }
    }
}