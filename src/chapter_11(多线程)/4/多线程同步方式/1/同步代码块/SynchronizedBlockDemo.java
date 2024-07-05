/*

    同步代码块
        同步代码块使用 synchronized 关键字加上一个锁对象括住一段代码。
        它提供了更高的灵活性，因为可以选择只同步需要同步的部分代码，而不是整个方法。

    使用场景
        适用于只有部分代码需要同步的情况，可以减少锁的持有时间，提高性能。
        例如，只保护关键代码段（如对共享资源的修改），而其他不涉及共享资源的代码不需要同步。

    优点
        同步范围小，性能更高，灵活性强

    缺点
        代码复杂度增加，需要更加小心地设计和实现。

 */
class SynchronizedBlock {
    private int count = 0;
    private static int countStatic = 0;

    // 增加计数器的方法
    public void increment() {
        //锁定 this 是一种实例级别的锁。它用于保护当前实例的状态，确保多个线程在访问和修改当前实例的成员变量时是线程安全的
        synchronized (this) {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
        }
    }

    // 获取计数器的值
    public int getCount() {
        synchronized (this) {
            return count;
        }
    }

    // 增加计数器的方法
    public void incrementStatic() {
        //锁定 Counter.class 是一种类级别的锁。它用于保护类的静态成员变量，确保多个线程在访问和修改静态成员变量时是线程安全的
        synchronized (SynchronizedBlock.class) {
            countStatic++;
            System.out.println(Thread.currentThread().getName() + " incremented count to: " + countStatic);
        }
    }

    // 获取计数器的值
    public int getCountStatic() {
        synchronized (SynchronizedBlock.class) {
            return countStatic;
        }
    }
}

public class SynchronizedBlockDemo {
    public static void main(String[] args) {
        SynchronizedBlock counter1 = new SynchronizedBlock();
        SynchronizedBlock counter2 = new SynchronizedBlock();

        //使用lambda表达式简化匿名内部类的实现，同时简化了run()方法的重写
        Runnable task1 = () -> {
            for (int i = 0; i < 10; i++) {
                counter1.increment();
                try {
                    Thread.sleep(50);  // 模拟其他操作的延迟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 10; i++) {
                counter2.incrementStatic();
                try {
                    Thread.sleep(50);  // 模拟其他操作的延迟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(task1, "线程1");
        Thread thread2 = new Thread(task1, "线程2");

        Thread thread3 = new Thread(task2, "线程3");
        Thread thread4 = new Thread(task2, "线程4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终实例类计数值: " + counter1.getCount());
        System.out.println("最终静态类计数值: " + counter2.getCountStatic());
    }
}