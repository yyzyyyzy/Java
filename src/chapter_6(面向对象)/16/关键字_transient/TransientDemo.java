import java.beans.Transient;
import java.io.*;

class TransientPerson implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    // transient关键字用于声明不需要被序列化的类成员变量，当对象被反序列化时，这些变量将不会被恢复，而是被初始化为其默认值
    private transient String password;

    public TransientPerson(String name, int age, String password) {
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

public class TransientDemo {
    public static void main(String[] args) {
        String fileName = "person.dat";

        // 创建一个 Person 对象
        TransientPerson person = new TransientPerson("Alice", 30, "password123");

        // 序列化对象
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(person);
            System.out.println("对象已成功序列化到文件 " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            TransientPerson deserializedPerson = (TransientPerson) ois.readObject();
            System.out.println("从文件中反序列化的对象:");
            System.out.println(deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

