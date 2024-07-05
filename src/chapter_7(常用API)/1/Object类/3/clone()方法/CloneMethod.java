/*

Object 类的 clone() 方法是用于创建对象的浅拷贝。

使用clone方法：
1. 实现 Cloneable 接口，否则会抛出 CloneNotSupportedException 异常。
2. 重写 clone() 方法，并在其中调用 super.clone()。

 */


class CloneMethod implements Cloneable {
    private String name;
    private int age;

    public CloneMethod(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        try {
            // 创建一个 Person 对象
            CloneMethod person1 = new CloneMethod("Alice", 30);

            // 克隆 person1 创建 person2
            CloneMethod person2 = (CloneMethod) person1.clone();

            // 打印两个对象的信息
            System.out.println("person1: " + person1); // 输出: Person{name='Alice', age=30}
            System.out.println("person2: " + person2); // 输出: Person{name='Alice', age=30}

            // 比较两个对象的引用和内容
            System.out.println("person1 == person2: " + (person1 == person2)); // 输出: false
            System.out.println("person1.equals(person2): " + person1.equals(person2)); // 输出: true

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    // 重写 toString 方法以便打印对象信息
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    // 重写 clone 方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 调用 Object 的 clone 方法
    }
}
