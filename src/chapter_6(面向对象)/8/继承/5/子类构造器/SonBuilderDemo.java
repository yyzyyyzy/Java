class People {
    private String name;
    private String age;

    public People() {

    }

    public People(String name, String age) {
        this.name = name;
        this.age = age;
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
}
//子类的全部构造器，都会先调用父类的无参构造器，再调用自己，如果父类没有无参构造器，需要手动加上super(xxx)带上所需要的参数

class Teacher extends People {
    private String skills;

    public Teacher(String name, String age, String skills) {
        super(name, age);
        this.skills = skills;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}

public class SonBuilderDemo {
    public static void main(String[] args) {
        Teacher t = new Teacher("lzk", "18", "育人");
        System.out.println(t.getName());
        System.out.println(t.getAge());
        System.out.println(t.getSkills());
    }
}
