// 继承 Thread 类
class ThreadCreateExtendDemo extends Thread {
    private String threadName;

    // 构造函数，接受线程名作为参数
    public ThreadCreateExtendDemo(String threadName) {
        this.threadName = threadName;
    }

    // 重写 run() 方法
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
        // 创建 MyThread 类的实例
        ThreadCreateExtendDemo thread1 = new ThreadCreateExtendDemo("Thread 1");
        ThreadCreateExtendDemo thread2 = new ThreadCreateExtendDemo("Thread 2");

        // 启动线程
        thread1.start();
        thread2.start();
    }
}
