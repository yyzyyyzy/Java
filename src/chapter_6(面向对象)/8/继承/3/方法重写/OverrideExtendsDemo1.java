class Animal3 {
    private String name;
    private String age;

    public Animal3() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override //重写Object父类的toString方法，不然只能打印对象的内存地址
    public String toString() {
        return "Animal2{name: " + name + ", age: " + age + "}";
    }
}

public class OverrideExtendsDemo1 {
    public static void main(String[] args) {
        Animal3 a2 = new Animal3();
        a2.setName("dog");
        a2.setAge("11");
        System.out.println(a2);
    }
}