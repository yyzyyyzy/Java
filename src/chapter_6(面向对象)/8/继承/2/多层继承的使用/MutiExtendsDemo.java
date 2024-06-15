class Animal1 {
    public void method() {
        System.out.println("hello1");

    }
}

class Dog1 extends Animal1 {
    public void method() {
        System.out.println("hello2");

    }
}

class DogSon1 extends Dog1 {
    public void method() {
        System.out.println("hello3");

    }
}


public class MutiExtendsDemo {
    public static void main(String[] args) {
        DogSon1 ds1 = new DogSon1();
        ds1.method();
    }
}
