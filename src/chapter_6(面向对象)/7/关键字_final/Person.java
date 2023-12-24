package 关键字_final;

public class Person {

    public static final String APP_NAME = "MyApp";
    public static final String APP_VERSION = "1.0.0";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    static String name;
    private static int count;
    public final String location = "江苏";
    int age;

    public Person() {
        count++; // 每次创建学生对象时增加计数
    }

    public static int getCount() {
        return count;
    }
}
