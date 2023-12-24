package 关键字_this;

public class Person {

    //this关键字：指向自己的引用（避免自我赋值）
    private String name;

    public void getName() {

        this.name = "mmp";
        String name = "lzk";

        //就近原则：相同的name先打印函数内的局部变量，不打印成员变量
        System.out.println(name);
        System.out.println(this.name);
    }
}