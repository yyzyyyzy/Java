package 接口的应用案例;

import java.util.ArrayList;

public class StudentsOperatorImpl2 implements 接口的应用案例.StudentsOperator {
    @Override
    public void printStudentsInfo(ArrayList<接口的应用案例.Students> students) {
        int maleCount = 0;
        int femaleCount = 0;
        System.out.println("--------------------全班同学信息如下--------------------");
        for (int i = 0; i < students.size(); i++) {
            接口的应用案例.Students s = students.get(i);
            if (s.getSex() == '男') {
                maleCount++;
            }
            if (s.getSex() == '女') {
                femaleCount++;
            }
        }
        System.out.println("男生人数为" + maleCount);
        System.out.println("女生人数为" + femaleCount);
        System.out.println("班级总人数为" + students.size());
        System.out.println("------------------------------------------------------");
    }

    @Override
    public void printAverageScore(ArrayList<接口的应用案例.Students> students) {
        double allScore = 0;
        double maxScore = students.get(0).getScore();
        double minScore = students.get(0).getScore();
        for (int i = 0; i < students.size(); i++) {
            接口的应用案例.Students s = students.get(i);
            if (s.getScore() > maxScore) {
                maxScore = s.getScore();
            }
            if (s.getScore() < minScore) {
                minScore = s.getScore();
            }
            allScore += s.getScore();
        }
        System.out.println("平均分" + (allScore - maxScore - minScore) / (students.size() - 2));
    }
}