package 关键字_private;

public class Person {

    //权限修饰符：被修饰的成员只可以在本类中使用
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        age = a;
    }

}