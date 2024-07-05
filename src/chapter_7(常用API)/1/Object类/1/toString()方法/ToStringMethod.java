public class ToStringMethod {
    private String name;
    private int age;

    public ToStringMethod(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        ToStringMethod person = new ToStringMethod("Alice", 30);
        // 调用toString方法
        System.out.println(person);
        System.out.println(person.toString());
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
