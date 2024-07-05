import java.util.Arrays;
import java.util.Comparator;

class ArraysCustomObj {
    private String name;
    private int age;
    private double gpa;

    // 构造方法和 getter/setter 略
    public ArraysCustomObj(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }
}

public class ArraysCustomObjDemo {
    public static void main(String[] args) {
        ArraysCustomObj[] students = {
                new ArraysCustomObj("Alice", 20, 3.5),
                new ArraysCustomObj("Bob", 18, 3.2),
                new ArraysCustomObj("Carol", 22, 3.8)
        };

        // 使用 Comparator 接口定义排序规则
        Comparator<ArraysCustomObj> ageComparator = new Comparator<ArraysCustomObj>() {
            @Override
            public int compare(ArraysCustomObj s1, ArraysCustomObj s2) {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        };

        // 使用 Comparator 接口定义排序规则
        Comparator<ArraysCustomObj> gpaComparator = new Comparator<ArraysCustomObj>() {
            @Override
            public int compare(ArraysCustomObj s1, ArraysCustomObj s2) {
                return Double.compare(s1.getGpa(), s2.getGpa());
            }
        };

        // 使用 Comparator 接口进行排序
        Arrays.sort(students, ageComparator);
        Arrays.sort(students, gpaComparator);

        // 输出排序后的结果
        for (ArraysCustomObj student : students) {
            System.out.println(student);
        }
    }
}