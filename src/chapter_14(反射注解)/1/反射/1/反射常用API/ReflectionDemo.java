import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            // 1. 获取类对象
            Class<?> clazz = ReflectionClass.class;

            System.out.println("Class Name: " + clazz.getName());

            // 2. 创建实例
            ReflectionClass person1 = (ReflectionClass) clazz.newInstance(); // 不推荐使用
            Constructor<?> constructor = clazz.getConstructor();
            ReflectionClass person2 = (ReflectionClass) constructor.newInstance();

            // 3. 获取构造方法并使用
            Constructor<?> personConstructor1 = clazz.getConstructor();
            Constructor<?> personConstructor2 = clazz.getConstructor(String.class);

            // 使用无参构造器创建实例
            ReflectionClass person3 = (ReflectionClass) personConstructor1.newInstance();
            System.out.println("Person3 (default constructor): " + person3.getName());

            // 使用有参构造器创建实例
            ReflectionClass person4 = (ReflectionClass) personConstructor2.newInstance("Alice");
            System.out.println("Person4 (parameterized constructor): " + person4.getName());

            // 4. 获取字段
            Field publicField = clazz.getField("publicField");
            Field privateField = clazz.getDeclaredField("privateField");

            // 5. 获取方法
            Method getNameMethod = clazz.getMethod("getName");
            Method privateMethod = clazz.getDeclaredMethod("privateMethod");

            // 6. 调用方法
            String name = (String) getNameMethod.invoke(person4);
            System.out.println("Name retrieved using getName: " + name);

            // 7. 访问和修改字段
            publicField.set(person3, "John");
            System.out.println("Public Field: " + publicField.get(person3));

            privateField.setAccessible(true); // 使私有字段可以访问
            privateField.set(person3, "Doe"); // 修改私有字段的值
            System.out.println("Private Field: " + privateField.get(person3));

            // 调用 private 方法
            privateMethod.setAccessible(true);
            privateMethod.invoke(person3);

            // 8. 获取类信息
            System.out.println("Class Name: " + clazz.getName());
            int modifiers = clazz.getModifiers();
            System.out.println("Modifiers: " + Modifier.toString(modifiers));
            Class<?> superclass = clazz.getSuperclass();
            System.out.println("Superclass: " + superclass.getName());

            Class<?>[] interfaces = clazz.getInterfaces();
            System.out.print("Interfaces: ");
            for (Class<?> iface : interfaces) {
                System.out.print(iface.getName() + " ");
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReflectionClass {
    public String publicField;
    private String privateField;

    public ReflectionClass() {
        this.publicField = "Default Name";
    }

    public ReflectionClass(String name) {
        this.publicField = name;
    }

    public String getName() {
        return publicField;
    }

    private void privateMethod() {
        System.out.println("Private method called");
    }
}
