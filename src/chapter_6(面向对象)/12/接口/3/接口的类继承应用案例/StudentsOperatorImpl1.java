package 接口的应用案例;

import java.util.ArrayList;

public class StudentsOperatorImpl1 implements 接口的应用案例.StudentsOperator {
    @Override
    public void printStudentsInfo(ArrayList<接口的应用案例.Students> students) {
        System.out.println("--------------------全班同学信息如下--------------------");
        for (int i = 0; i < students.size(); i++) {
            接口的应用案例.Students s = students.get(i);
            System.out.println("姓名" + s.getName() + "性别" + s.getSex() + "成绩" + s.getScore());
        }
        System.out.println("------------------------------------------------------");
    }

    @Override
    public void printAverageScore(ArrayList<接口的应用案例.Students> students) {
        double allScore = 0;
        for (int i = 0; i < students.size(); i++) {
            接口的应用案例.Students s = students.get(i);
            allScore += s.getScore();
        }
        System.out.println("平均分" + allScore / students.size());
    }
}