package 接口的应用案例;

import java.util.ArrayList;

public class ClassManager {
    private ArrayList<接口的应用案例.Students> students = new ArrayList<>();
    private 接口的应用案例.StudentsOperator studentsOperator = new 接口的应用案例.StudentsOperatorImpl1();
//    private 接口的应用案例.StudentsOperator studentsOperator = new 接口的应用案例.StudentsOperatorImpl2();


    public ClassManager() {
        students.add(new 接口的应用案例.Students("lzk", '男', 100));
        students.add(new 接口的应用案例.Students("zj", '男', 90));
        students.add(new 接口的应用案例.Students("whc", '男', 80));
        students.add(new 接口的应用案例.Students("zk", '男', 70));
    }

    // 打印全班学生的信息
    public void printInfo() {
        studentsOperator.printStudentsInfo(students);
    }


    // 打印全班学生的平均分
    public void printAverageScore() {
        studentsOperator.printAverageScore(students);
    }
}