package 多态的使用;

public class Police extends 多态的使用.HumanBeing {
    public String name = "警察";

    @Override
    public void run() {
        System.out.println("警察跑");
    }

    public void shoot() {
        System.out.println("警察射击");
    }
}
