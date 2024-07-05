import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// 实现 Callable 接口
class ThreadCreateCallableFutureDemo implements Callable<String> {
    private String threadName;

    // 构造函数，接受线程名作为参数
    public ThreadCreateCallableFutureDemo(String threadName) {
        this.threadName = threadName;
    }

    // 实现 call() 方法
    @Override
    public String call() {
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + " is running: " + i);
            try {
                // 使线程休眠一段时间，以便更好地观察线程执行
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
        return threadName + " has finished executing.";
    }

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 创建 Callable 任务实例
        ThreadCreateCallableFutureDemo callable1 = new ThreadCreateCallableFutureDemo("Thread 1");
        ThreadCreateCallableFutureDemo callable2 = new ThreadCreateCallableFutureDemo("Thread 2");

        // 提交 Callable 任务并获取 Future 对象
        Future<String> future1 = executorService.submit(callable1);
        Future<String> future2 = executorService.submit(callable2);

        try {
            // 获取任务执行结果
            String result1 = future1.get();
            String result2 = future2.get();

            // 输出任务执行结果
            System.out.println(result1);
            System.out.println(result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
