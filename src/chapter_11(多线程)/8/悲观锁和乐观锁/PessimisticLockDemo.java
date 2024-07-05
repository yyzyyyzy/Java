/*

    悲观锁：

        1.问题解决：悲观锁认为数据在多线程环境下可能会发生冲突，因此在访问数据时会悲观地认为其他线程会修改数据，
        因此采取加锁的方式保护数据。

        2.实现方式：通过在访问数据前获取锁，确保同一时刻只有一个线程可以访问数据，其他线程需要等待锁释放后才能访问，
        保证数据的完整性和一致性。

        3.适用场景：适用于对数据并发访问要求较高、频繁修改的场景，例如数据库的行锁、表锁等。

 */

class PessimisticLock {
    private int balance;

    public PessimisticLock(int initialBalance) {
        this.balance = initialBalance;
    }

    // 使用同步方法实现悲观锁
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " 存款 " + amount + "，余额：" + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " 取款 " + amount + "，余额：" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " 取款失败，余额不足：" + balance);
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}

public class PessimisticLockDemo {
    public static void main(String[] args) {
        PessimisticLock account = new PessimisticLock(1000);

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100);
                account.withdraw(50);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(task, "线程1");
        Thread thread2 = new Thread(task, "线程2");

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
