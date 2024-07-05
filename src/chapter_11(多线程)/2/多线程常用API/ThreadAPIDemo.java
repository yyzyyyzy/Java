public class ThreadAPIDemo {
    public static void main(String[] args) {
        // 创建 Runnable 对象
        ThreaAPI runnable1 = new ThreaAPI("Thread 1");
        ThreaAPI runnable2 = new ThreaAPI("Thread 2");
        ThreaAPI runnable3 = new ThreaAPI("Thread 3");

        // 创建 Thread 对象并启动线程
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

        // 设置线程优先级（常量: Thread.MIN_PRIORITY (1), Thread.NORM_PRIORITY (5), Thread.MAX_PRIORITY (10)）
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);

        // 将线程设置为守护线程
        thread1.setDaemon(true);

        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();

        // 检查线程状态
        System.out.println("Thread 1 is alive: " + thread1.isAlive());
        System.out.println("Thread 2 is alive: " + thread2.isAlive());
        System.out.println("Thread 3 is alive: " + thread3.isAlive());

        // 让主线程等待子线程执行完成（最长为 millis 毫秒）
        try {
            thread1.join(100);
            thread2.join(100);
            thread3.join(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 1 is interrupted: " + thread1.isInterrupted());
        System.out.println("Thread 2 is interrupted: " + thread2.isInterrupted());
        System.out.println("Thread 2 is interrupted: " + thread3.isInterrupted());

        System.out.println("Main thread finished.");
    }
}

class ThreaAPI implements Runnable {
    private String threadName;

    public ThreaAPI(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println(threadName + " is running...");
        try {
            // 使当前正在执行的线程（最长为 millis 毫秒）
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }
        System.out.println(threadName + " has finished.");
    }
}
