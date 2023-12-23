public class IfDemo {
    public static void main(String[] args) {

        int a = 1;
        if (a > 1) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }

        boolean flag = false;
        if (flag) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }

        int rank = 88;
        if (rank >= 60) {
            System.out.println("及格");
        } else if (rank == 100) {
            System.out.println("满分");
        } else {
            System.out.println("不及格");
        }
    }
}