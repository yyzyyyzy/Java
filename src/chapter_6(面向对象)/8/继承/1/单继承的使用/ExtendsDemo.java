class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Mouse extends Animal {
    private String skills;

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void printInfo() {
        System.out.println(getName() + "具备的技能" + skills);
    }
}

public class ExtendsDemo {
    public static void main(String[] args) {
        Mouse m = new Mouse();
        m.setName("老鼠");
        m.setSkills("打洞");
        System.out.println(m.getName());
        System.out.println(m.getSkills());
        m.printInfo();
    }
}