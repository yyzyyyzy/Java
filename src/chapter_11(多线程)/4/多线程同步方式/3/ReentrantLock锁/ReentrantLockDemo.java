import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockClass {
    private int balance;
    // final关键字对lock进行保护，无法进行二次赋值
    private final Lock lock = new ReentrantLock();


    public ReentrantLockClass(int initialBalance) {
        this.balance = initialBalance;
    }

    // 存款操作
    public void deposit(int amount) {
        lock.lock();  // 获取锁
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " 存款 " + amount + "，余额：" + balance);
        } finally {
            lock.unlock();  // 释放锁
        }
    }

    // 取款操作
    public void withdraw(int amount) {
        lock.lock();  // 获取锁
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " 取款 " + amount + "，余额：" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " 取款失败，余额不足：" + balance);
            }
        } finally {
            lock.unlock();  // 释放锁
        }
    }

    // 获取余额
    public int getBalance() {
        lock.lock();  // 获取锁
        try {
            return balance;
        } finally {
            lock.unlock();  // 释放锁
        }
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLockClass account = new ReentrantLockClass(1000);

        // 创建两个线程对同一个账户进行存取款操作
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    account.deposit(100);
                    account.withdraw(50);
                    try {
                        Thread.sleep(50);  // 模拟其他操作的延迟
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    account.deposit(200);
                    account.withdraw(150);
                    try {
                        Thread.sleep(50);  // 模拟其他操作的延迟
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread1 = new Thread(task1, "线程1");
        Thread thread2 = new Thread(task2, "线程2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终账户余额：" + account.getBalance());
    }
}