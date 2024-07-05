package 定义泛型类;

// 泛型类的定义
public class GenericsClass<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}