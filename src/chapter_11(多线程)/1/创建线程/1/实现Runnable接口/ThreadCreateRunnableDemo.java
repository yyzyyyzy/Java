// 通过实现 Runnable 接口来创建线程，为了实现 Runnable，一个类只需要执行一个方法调用 run()
class ThreadCreateRunnableDemo implements Runnable {
    private String threadName;

    // 构造函数，接受线程名作为参数
    public ThreadCreateRunnableDemo(String threadName) {
        this.threadName = threadName;
    }

    // 实现 run() 方法
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + " is running: " + i);
            try {
                // 使线程休眠一段时间，以便更好地观察线程执行
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
        System.out.println(threadName + " has finished executing.");
    }

    public static void main(String[] args) {
        // 创建 Runnable 实现类的实例
        ThreadCreateRunnableDemo runnable1 = new ThreadCreateRunnableDemo("Thread 1");
        ThreadCreateRunnableDemo runnable2 = new ThreadCreateRunnableDemo("Thread 2");

        // 创建线程并传入 Runnable 实现类的实例
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        // 启动线程
        thread1.start();
        thread2.start();
    }
}
