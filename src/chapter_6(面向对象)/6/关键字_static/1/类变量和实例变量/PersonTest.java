//类变量：与类相关的变量，具有唯一性和共享性，常用于存储可变的数据，如计数器、全局状态等
public class PersonTest {
    public static void main(String[] args) {
        Person.name = "lzk";

        Person s1 = new Person();
        Person.name = "kkk";
        s1.age = 11;

        Person s2 = new Person();
        Person.name = "qqq";
        s2.age = 22;

        System.out.println(Person.name);
        System.out.println(s1.age);
        System.out.println(Person.name);
        System.out.println(s2.age);
        System.out.println(Person.getCount());
    }
}

class Person {
    static int count; //唯一性和共享性
    static String name; //唯一性和共享性
    int age;

    public Person() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}



