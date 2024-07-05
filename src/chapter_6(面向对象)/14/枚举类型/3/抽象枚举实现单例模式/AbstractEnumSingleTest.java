package 抽象枚举实现单例模式;

public class AbstractEnumSingleTest {
    public static void main(String[] args) {
        // 使用单例
        抽象枚举实现单例模式.AbstractEnumSingle singleton = 抽象枚举实现单例模式.AbstractEnumSingle.INSTANCE;
        // 输出：Initial data
        System.out.println(singleton.getData());

        // 修改数据
        singleton.setData("New data");
        // 输出：New data
        System.out.println(singleton.getData());

        // 获取同一个实例
        抽象枚举实现单例模式.AbstractEnumSingle anotherInstance = 抽象枚举实现单例模式.AbstractEnumSingle.INSTANCE;
        // 输出：New data
        System.out.println(anotherInstance.getData());
    }
}