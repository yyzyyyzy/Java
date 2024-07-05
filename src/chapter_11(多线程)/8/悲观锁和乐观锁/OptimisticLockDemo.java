import java.util.concurrent.atomic.AtomicInteger;

/*

    乐观锁：

        1.问题解决：乐观锁认为数据在多线程环境下不会发生冲突，因此不需要加锁，
        而是在更新数据时通过版本号或者时间戳等机制进行比较，来判断数据是否被修改。

        2.实现方式：在读取数据时不加锁，而是在更新数据时先比较当前版本号或时间戳等，
        如果与预期相符则更新成功，否则认为数据已经被修改，需要进行相应的冲突处理。

        3.适用场景：适用于读操作频繁、写操作相对较少、并发冲突较少的场景，可以提高系统的并发性能，减少对锁的依赖。

 */

class OptimisticLock {
    private AtomicInteger stock;

    public OptimisticLock(int initialStock) {
        this.stock = new AtomicInteger(initialStock);
    }

    // 使用版本号实现乐观锁
    public boolean decreaseStock(int amount) {
        // 库存
        int oldStock;
        int newStock;
        do {
            // 获取当前库存量的值
            oldStock = stock.get();
            // 如果库存不足
            if (oldStock < amount) {
                System.out.println(Thread.currentThread().getName() + " 减少库存失败，库存不足：" + oldStock);
                return false;
            }
            // 计算新的库存值，即减少指定数量后的库存量
            newStock = oldStock - amount;
            //使用 compareAndSet 方法尝试原子地更新库存值。该方法比较当前值（oldStock）和期望值（即 compare 参数），
            //如果相等，则更新为新值（newStock）。如果更新失败（即当前值已经被其他线程修改），
            //则重新获取当前库存值，重新计算并尝试更新，直到更新成功
        } while (!stock.compareAndSet(oldStock, newStock));

        System.out.println(Thread.currentThread().getName() + " 减少库存 " + amount + "，剩余库存：" + newStock);
        return true;
    }

    public int getStock() {
        return stock.get();
    }
}

public class OptimisticLockDemo {
    public static void main(String[] args) {
        OptimisticLock inventory = new OptimisticLock(100);

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                inventory.decreaseStock(10);
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

        System.out.println("最终库存：" + inventory.getStock());
    }
}
