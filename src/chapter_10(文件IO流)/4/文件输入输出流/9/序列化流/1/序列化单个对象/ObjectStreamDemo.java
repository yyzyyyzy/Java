import java.io.*;

public class ObjectStreamDemo {
    public static void main(String[] args) {
        String fileName = "serializedObject.dat";

        // 1.使用 ObjectOutputStream 将对象序列化为字节流并写入文件
        ObjectStream person = new ObjectStream("Alice", 30);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // 将对象序列化到文件
            oos.writeObject(person);

            System.out.println("对象已成功序列化到文件 " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2.使用 ObjectInputStream 从文件中读取序列化的对象并进行反序列化：
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // 从文件中读取对象
            ObjectStream object = (ObjectStream) ois.readObject();

            System.out.println("从文件中反序列化的对象:");
            System.out.println(object);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// 示例对象类
// ObjectStream 类实现了 Serializable 接口，这是 Java 序列化的关键。
// 序列化接口没有方法，它只是一个标记接口，用于指示 JVM 可以将该类的对象转换为字节序列
class ObjectStream implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient String high;

    public ObjectStream(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}