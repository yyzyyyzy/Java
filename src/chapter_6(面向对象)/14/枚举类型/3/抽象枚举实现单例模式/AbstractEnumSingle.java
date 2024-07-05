package 抽象枚举实现单例模式;

public enum AbstractEnumSingle {
    INSTANCE;

    // 可以添加其他需要单例管理的属性
    private String data;

    AbstractEnumSingle() {
        // 初始化单例对象的一些操作
        data = "Initial data";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}