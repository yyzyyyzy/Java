import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        System.out.println("学生管理系统");
        System.out.println("1-查询学生");
        System.out.println("2-添加学生");
        System.out.println("3-删除学生");
        System.out.println("4-更新学生");

        ArrayList<Student> students = new ArrayList<>();


        while (true) {
            System.out.println("请输入功能编号【1-4】，或按 0 退出：");
            Scanner sc = new Scanner(System.in);
            int action = sc.nextInt();
            switch (action) {
                case 0:
                    return;
                case 1:
                    queryStudent(sc, students);
                    break;
                case 2:
                    addStudent(sc, students);
                    break;
                case 3:
                    deleteStudent(sc, students);
                    break;
                case 4:
                    updateStudent(sc, students);
                    break;
                default:
                    System.out.println("请重新输入正确的功能编号【1-4】");
                    break;
            }
        }
    }

    private static void updateStudent(Scanner sc, ArrayList<Student> students) {
        System.out.println("请输入要更新的学生姓名：");
        String name4 = sc.next();
        boolean updated = false;
        for (Student s : students) {
            if (name4.equalsIgnoreCase(s.getName())) {
                students.remove(s);
                System.out.println("请输入新的学生姓名：");
                String name5 = sc.next();
                System.out.println("请输入新的学生年龄：");
                int age5 = sc.nextInt();
                s.setName(name5);
                s.setAge(age5);
                updated = true;
                break;
            }
        }
        if (updated) {
            System.out.println("更新成功");
        } else {
            System.out.println("未找到匹配的学生信息");
        }
    }

    private static void deleteStudent(Scanner sc, ArrayList<Student> students) {
        System.out.println("请输入要删除的学生姓名：");
        String name3 = sc.next();
        boolean removed = false;
        for (Student s : students) {
            if (name3.equalsIgnoreCase(s.getName())) {
                students.remove(s);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("删除成功");
        } else {
            System.out.println("未找到匹配的学生信息");
        }
    }

    private static void addStudent(Scanner sc, ArrayList<Student> students) {
        System.out.println("请输入要添加的学生姓名：");
        String name2 = sc.next();
        System.out.println("请输入要添加的学生年龄：");
        int age2 = sc.nextInt();
        Student student = new Student();
        student.setName(name2);
        student.setAge(age2);
        students.add(student);
    }

    private static void queryStudent(Scanner sc, ArrayList<Student> students) {
        System.out.println("请输入学生姓名：");
        String name1 = sc.next();
        boolean found = false;
        for (Student s : students) {
            if (name1.equalsIgnoreCase(s.getName())) {
                System.out.println("姓名：" + s.getName() + "，年龄：" + s.getAge());
                found = true;
            }
        }
        if (!found) {
            System.out.println("未找到匹配的学生信息");
        }
    }
}

class Student {

    public static int count;
    private int age;
    private String name;

    public Student() {
        count++;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}