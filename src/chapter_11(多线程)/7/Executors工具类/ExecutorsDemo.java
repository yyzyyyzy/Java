import java.util.concurrent.*;

public class ExecutorsDemo {
    public static void main(String[] args) {
        //1. Fixed Thread Pool（固定大小线程池）：
            //场景：适用于需要限制线程数量的场景，可以有效控制并发线程的数量，防止系统资源被大量线程占用。
            //优点：核心线程数量固定，任务队列不限长度，因此即使任务很多，线程池也不会崩溃。
            //示例：后台服务器处理固定数量的请求，处理批量文件操作等。
        fixedThreadPoolExample();
        //2. Cached Thread Pool（缓存线程池）：
            //场景：适用于执行很多短期异步任务，或者负载较轻的服务器。
            //优点：能够根据需要创建新线程，并在先前创建的线程空闲时重用它们。空闲线程会在60秒后被回收。
            //示例：短期任务、服务器请求处理等。
        cachedThreadPoolExample();
        //3. Single Thread Executor（单线程池）：
            //场景：适用于需要保证顺序执行各个任务的场景，且同一时间只有一个任务被执行。
            //优点：提供单一工作线程来执行任务，确保任务按提交顺序执行。
            //示例：日志处理、事件处理、顺序任务执行等。
        singleThreadExecutorExample();
        //4. Scheduled Thread Pool（调度线程池）：
            //场景：适用于需要在给定的延迟后运行任务，或者周期性地执行任务的场景。
            //优点：可以定时或周期性地执行任务。
            //示例：周期性数据备份、定时报告生成、心跳检测等。
        scheduledThreadPoolExample();
    }

    // 固定大小线程池示例
    public static void fixedThreadPoolExample() {
        System.out.println("Fixed Thread Pool Example:");
        // 创建一个固定大小的线程池，线程池中的线程数为4
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            int taskId = i;
            Future<Integer> future = executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " 执行任务 " + taskId);
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " 完成任务 " + taskId);
                return taskId;
            });

            try {
                Integer result = future.get();
                System.out.println("任务 " + result + " 执行完毕");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Fixed Thread Pool Example 完成\n");
    }

    // 缓存线程池示例
    public static void cachedThreadPoolExample() {
        System.out.println("Cached Thread Pool Example:");
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " 执行任务 " + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " 完成任务 " + taskId);
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Cached Thread Pool Example 完成\n");
    }

    // 单线程池示例
    public static void singleThreadExecutorExample() {
        System.out.println("Single Thread Executor Example:");
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " 执行任务 " + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " 完成任务 " + taskId);
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Single Thread Executor Example 完成\n");
    }

    // 调度线程池示例
    public static void scheduledThreadPoolExample() {
        System.out.println("Scheduled Thread Pool Example:");
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        // 提交一个定时任务，每隔2秒执行一次
        executor.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + " 执行定时任务");
        }, 0, 2, TimeUnit.SECONDS);

        // 提交一个定时任务，延迟3秒执行
        executor.schedule(() -> {
            System.out.println(Thread.currentThread().getName() + " 执行延迟任务");
        }, 3, TimeUnit.SECONDS);

        // 等待一段时间后关闭调度线程池
        try {
            Thread.sleep(10000); // 等待10秒
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Scheduled Thread Pool Example 完成\n");
    }
}