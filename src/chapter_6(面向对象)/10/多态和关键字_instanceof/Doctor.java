package 多态的使用;

public class Doctor extends 多态的使用.HumanBeing {
    public String name = "医生";

    @Override
    public void run() {
        System.out.println("医生跑");
    }

    public void care() {
        System.out.println("医生的关怀");
    }
}
