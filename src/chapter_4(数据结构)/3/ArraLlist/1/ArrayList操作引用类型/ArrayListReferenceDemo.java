import java.util.ArrayList;

public class ArrayListReferenceDemo {
    public static void main(String[] args) {

        //数组是一种静态的数据结构，大小固定且类型一致；
        //ArrayList 是动态的容器类，可以根据需要动态调整大小，存储各种类型的对象。

        //泛型：限定集合中存储数据的类型
        ArrayList<String> list = new ArrayList<>();

        //增：
        list.add(0, "lzk");
        list.add(1, "lzk");
        list.add(2, "lzk");
        list.add(3, "lzk");
        list.add(4, "lzk");

        //删
        list.remove("lzk");

        //改
        list.set(0, "kzl");

        //查
        //查元素
        list.get(0);

        //查大小
        list.size();

        //遍历查元素
        for (String s : list) {
            System.out.println(s);
        }
    }
}