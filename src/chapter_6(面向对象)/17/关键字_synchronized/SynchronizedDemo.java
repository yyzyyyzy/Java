class ThreadSynchronizedClass {
    private int count = 0;

    // 使用 synchronized 关键字确保线程安全
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class ThreadSynchronizedInterface implements Runnable {
    private ThreadSynchronizedClass counter;

    public ThreadSynchronizedInterface(ThreadSynchronizedClass counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
    }
}

public class SynchronizedDemo {
    public static void main(String[] args) {
        ThreadSynchronizedClass counter = new ThreadSynchronizedClass();
        Thread thread1 = new Thread(new ThreadSynchronizedInterface(counter));
        Thread thread2 = new Thread(new ThreadSynchronizedInterface(counter));

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
