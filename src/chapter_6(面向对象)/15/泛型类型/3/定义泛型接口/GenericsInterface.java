package 定义泛型接口;

public interface GenericsInterface<T> {
    T getData(); // 方法返回值使用泛型类型

    void setData(T data); // 方法参数使用泛型类型
}

// 实现泛型接口
class MyGenericClass<T> implements GenericsInterface<T> {
    private T data;

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }
}
