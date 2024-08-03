import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalApiDemo {
    // 创建一个ThreadLocal对象
    private static ThreadLocal<String> currentUser = new ThreadLocal<>() {
        @Override
        protected String initialValue() {
            // 设置初始值
            return "Lzk";
        }
    };

    // 设置当前线程的登录用户
    public static void setLoggedInUser(String username) {
        currentUser.set(username);
    }

    // 获取当前线程的登录用户
    public static String getLoggedInUser() {
        return currentUser.get();
    }

    // 模拟用户登录的方法
    public static void simulateUserLogin() {
        // 假设这里通过随机选择一个用户登录
        String[] users = {"Alice", "Bob", "Charlie", "David"};
        String randomUser = users[ThreadLocalRandom.current().nextInt(users.length)];
        setLoggedInUser(randomUser);
        System.out.println("User " + randomUser + " logged in on thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建三个线程模拟用户登录
        Thread thread1 = new Thread(() -> {
            simulateUserLogin();
            System.out.println("Current logged in user in " + Thread.currentThread().getName() + ": " + getLoggedInUser());
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            simulateUserLogin();
            System.out.println("Current logged in user in " + Thread.currentThread().getName() + ": " + getLoggedInUser());
        }, "Thread-2");

        Thread thread3 = new Thread(() -> {
            simulateUserLogin();
            System.out.println("Current logged in user in " + Thread.currentThread().getName() + ": " + getLoggedInUser());
        }, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
}
