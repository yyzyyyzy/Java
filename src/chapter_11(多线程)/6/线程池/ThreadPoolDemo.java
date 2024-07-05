/*

    ThreadPoolExecutor 的构造函数有七个参数，它们依次是：

        1. corePoolSize：核心线程数，即使线程池中的线程处于空闲状态，也不会被销毁的线程数。
        2. maximumPoolSize：最大线程数，当队列满时，线程池能创建的最大线程数。
        3. keepAliveTime：非核心线程闲置超时时间，超过这个时间，非核心线程会被销毁。
        4. unit：时间单位，用于指定 keepAliveTime 的单位。

        5. workQueue：任务队列，用于存放等待执行的任务。
            new LinkedBlockingQueue<>()无界队列，可以无限制地添加任务，当线程池中的线程数达到核心线程数后，新任务将在队列中等待执行
            适合需要保持任务顺序执行的场景，或者希望任务能够缓冲一段时间以应对突发的任务提交。

            new ArrayBlockingQueue<>(2)有界队列，必须指定队列的容量。当队列满时，新任务将阻塞直到有空间可用或者线程池被关闭
            适合控制任务的最大数量，避免内存溢出，但要注意设置合理的队列大小。

            new SynchronousQueue<>()有实际存储元素的队列。每个插入操作必须等待另一个线程的对应移除操作，反之亦然。这种队列比较特殊，
            通常会与较小的线程池一起使用，或者用于直接将任务交给线程而不是放入队列中
            适合希望任务立即交给线程执行，且任务提交速度不超过线程处理速度的场景。

        6. threadFactory：线程工厂，用于创建新线程，可以定制线程的创建，比如给线程命名、设置线程的优先级、是否设置为守护线程等

        7. handler：拒绝策略，线程都在忙，任务队列也满了，此时新任务的处理方式。
            AbortPolicy（默认策略）直接抛出 RejectedExecutionException 异常，默认策略
            CallerRunsPolicy 将任务交给调用线程来执行，如果线程池被关闭，则会丢弃任务
            DiscardPolicy 直接丢弃被拒绝的任务，不做任何处理
            DiscardOldestPolicy 丢弃队列中等待时间最久的任务，然后尝试重新提交被拒绝的任务
 */

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建自定义线程工厂
        ThreadFactory threadFactory = new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                // 设置线程名字
                Thread thread = new Thread(r, "自定义线程-" + threadNumber.getAndIncrement());
                // 设置线程属性（优先级、守护线程）
                thread.setPriority(Thread.NORM_PRIORITY);
                thread.setDaemon(false);
                return thread;
            }
        };

        // 创建自定义线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,    // 核心线程数
                4,    // 最大线程数
                60,   // 空闲线程存活时间
                TimeUnit.SECONDS,   // 时间单位
                new ArrayBlockingQueue<>(2), // 有界任务队列，容量为2
                threadFactory,  // 线程工厂
                new ThreadPoolExecutor.CallerRunsPolicy() // 拒绝策略，将任务交给调用线程来执行（main）
        );

        // executor.submit() 获取任务执行结果，需要实现callable接口
        for (int i = 0; i < 10; i++) {
            // 创建不同的任务实例
            ThreadPoolCallableClass callableTask = new ThreadPoolCallableClass(i);
            Future<Integer> futureResult = executor.submit(callableTask);

            try {
                Integer result = futureResult.get();
                System.out.println("任务 " + i + " 的执行结果是：" + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        // executor.execute() 不获取任务执行结果
        for (int i = 0; i < 10; i++) {
            executor.execute(new ThreadPoolRunnableClass(i));
        }

        // 关闭线程池
        executor.shutdown();
        try {
            // 该方法阻塞当前线程，等待线程池中的所有任务在指定时间内完成
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                // 在指定时间之后优雅地关闭线程池
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("所有任务已完成");
    }
}

class ThreadPoolRunnableClass implements Runnable {
    private final int taskId;

    public ThreadPoolRunnableClass(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 执行任务 " + taskId);
        try {
            Thread.sleep(1000); // 模拟任务处理时间
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " 完成任务 " + taskId);
    }
}

class ThreadPoolCallableClass implements Callable<Integer> {
    private final int taskId;

    public ThreadPoolCallableClass(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " 执行任务 " + taskId);
        Thread.sleep(1000); // 模拟任务处理时间
        System.out.println(Thread.currentThread().getName() + " 完成任务 " + taskId);
        return taskId; // 返回任务执行结果
    }
}