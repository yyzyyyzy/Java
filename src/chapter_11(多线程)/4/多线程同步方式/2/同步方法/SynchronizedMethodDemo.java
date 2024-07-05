/*
    同步方法
        同步方法使用 synchronized 关键字直接修饰整个方法。它保证了在任何时候只有一个线程能够执行该方法

    使用场景
        适用于整个方法都需要同步的情况，通常用于保护方法中的所有操作

    优点
        代码简洁，易于理解和维护

    缺点
        同步范围大，可能导致不必要的性能开销
 */
class SynchronizedMethod {
    private int balance;

    public SynchronizedMethod(int initialBalance) {
        this.balance = initialBalance;
    }

    // 同步存款方法
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " 存款 " + amount + "，余额：" + balance);
    }

    // 同步取款方法
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " 取款 " + amount + "，余额：" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " 取款失败，余额不足：" + balance);
        }
    }

    // 同步获取余额方法
    public synchronized int getBalance() {
        return balance;
    }
}

public class SynchronizedMethodDemo {
    public static void main(String[] args) {
        SynchronizedMethod account = new SynchronizedMethod(1000);

        // 创建两个线程对同一个账户进行存取款操作
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    account.deposit(100);
                    account.withdraw(50);
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    account.deposit(200);
                    account.withdraw(150);
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
