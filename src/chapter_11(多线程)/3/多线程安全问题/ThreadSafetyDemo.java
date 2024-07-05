class ThreadSafetyClass {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class ThreadSafetyInterface implements Runnable {
    private ThreadSafetyClass counter;

    public ThreadSafetyInterface(ThreadSafetyClass counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
    }
}

public class ThreadSafetyDemo {
    public static void main(String[] args) {
        ThreadSafetyClass counter = new ThreadSafetyClass();
        Thread thread1 = new Thread(new ThreadSafetyInterface(counter));
        Thread thread2 = new Thread(new ThreadSafetyInterface(counter));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
