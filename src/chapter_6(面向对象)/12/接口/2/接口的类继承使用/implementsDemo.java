interface Driver {
    void drive();
}

interface Singer {
    void sing();
}

class S implements Driver, Singer {

    @Override
    public void drive() {

    }

    @Override
    public void sing() {

    }
}

public class implementsDemo {
    public static void main(String[] args) {
        Driver d = new S();
        d.drive();

        Singer s = new S();
        s.sing();
    }
}
