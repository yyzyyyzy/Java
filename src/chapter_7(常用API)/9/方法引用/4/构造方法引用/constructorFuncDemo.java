// 构造方法引用提供了一种简洁的方式来创建对象

interface ConstructorOperation {
    constructorFunc create(String name);
}

class constructorFunc {
    private String name;

    public constructorFunc(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class constructorFuncDemo {
    public static void main(String[] args) {
        // 使用匿名类实现接口返回constructorFunc对象
        ConstructorOperation personFactory1 = new ConstructorOperation() {
            @Override
            public constructorFunc create(String name) {
                return new constructorFunc(name);
            }
        };

        // 使用Lambda表达式返回constructorFunc对象
        ConstructorOperation personFactory2 = name -> new constructorFunc(name);

        // 使用构造方法引用来创建Person对象
        ConstructorOperation personFactory3 = constructorFunc::new;

        // 使用PersonFactory创建Person对象
        constructorFunc person1 = personFactory1.create("Alice");
        constructorFunc person2 = personFactory2.create("Alice");
        constructorFunc person3 = personFactory3.create("Alice");
        System.out.println("Person's name: " + person1.getName()); // 输出: Person's name: Alice
        System.out.println("Person's name: " + person2.getName()); // 输出: Person's name: Alice
        System.out.println("Person's name: " + person3.getName()); // 输出: Person's name: Alice
    }
}
