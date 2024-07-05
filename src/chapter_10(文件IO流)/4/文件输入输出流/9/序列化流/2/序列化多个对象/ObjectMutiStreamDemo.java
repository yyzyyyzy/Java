import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectMutiStreamDemo {
    public static void main(String[] args) {
        String fileName = "persons.dat";

        // 创建多个 Person 对象
        List<ObjectMutiStream> persons = new ArrayList<>();
        persons.add(new ObjectMutiStream("Alice", 30, "password123"));
        persons.add(new ObjectMutiStream("Bob", 25, "password456"));
        persons.add(new ObjectMutiStream("Charlie", 35, "password789"));

        // 序列化对象集合
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(persons);
            System.out.println("对象集合已成功序列化到文件 " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化对象集合
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<ObjectMutiStream> deserializedPersons = (List<ObjectMutiStream>) ois.readObject();
            System.out.println("从文件中反序列化的对象集合:");
            for (ObjectMutiStream person : deserializedPersons) {
                System.out.println(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ObjectMutiStream implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient String password; // 不希望序列化的字段

    public ObjectMutiStream(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
