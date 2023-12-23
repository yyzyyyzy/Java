package 标准的javabean;

public class Person {

    /*
    标准的javabean(可重用的java对象)：

    1. 类必须是公共的，并且具有一个无参的公共构造方法：这样可以确保其他类能够访问并实例化JavaBean。

    2. 属性必须使用私有访问修饰符：属性应该被封装起来，通过公共的Getter和Setter方法进行访问和修改。

    3. 提供公共的Getter和Setter方法：用于获取和设置属性的值。Getter方法用于获取属性值，Setter方法用于设置属性值。

    4. 应该实现可序列化接口（Serializable）：如果需要在网络上传输或将JavaBean保存到文件中，实现Serializable接口可以实现对象的序列化和反序列化。

    5. 具有符合JavaBean命名规范的属性名：根据JavaBean的命名规范，属性名应该以小写字母开头，并且使用驼峰命名法。

    6. 可选地实现Object类的toString()、equals()和hashCode()方法：这些方法可以增强JavaBean的功能和可读性。
     */

    private String name;
    private int age;

    public Person() {
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

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}