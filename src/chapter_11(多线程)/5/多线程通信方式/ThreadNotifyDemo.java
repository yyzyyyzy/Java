import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class ProducerClass implements Runnable {
    private final List<Integer> buffer;
    // capacity 是缓冲区的最大容量
    private final int capacity;

    public ProducerClass(List<Integer> buffer, int capacity) {
        this.buffer = buffer;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            synchronized (buffer) {
                // 当缓冲区满时，调用 buffer.wait() 方法，等待消费者消费数据
                while (buffer.size() >= capacity) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                buffer.add(value);
                System.out.println("生产者生产了: " + value);
                value++;
                // 当生产数据后，调用 buffer.notifyAll() 方法，通知等待的消费者
                buffer.notifyAll();
            }
            try {
                // 模拟生产延迟
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class ConsumerClass implements Runnable {
    private final List<Integer> buffer;

    public ConsumerClass(List<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                // 当缓冲区为空时，调用 buffer.wait() 方法，等待生产者生产数据
                while (buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                // 当消费数据后，调用 buffer.notifyAll() 方法，通知等待的生产者
                int value = buffer.remove(0);
                System.out.println("消费者消费了: " + value);
                buffer.notifyAll();
            }
            try {
                // 模拟消费延迟
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ThreadNotifyDemo {
    public static void main(String[] args) {
        List<Integer> buffer = new ArrayList<>();
        int capacity = 5;

        ProducerClass producer = new ProducerClass(buffer, capacity);
        ConsumerClass consumer = new ConsumerClass(buffer);

        Thread producerThread = new Thread(producer, "生产者");
        Thread consumerThread = new Thread(consumer, "消费者");

        producerThread.start();
        consumerThread.start();
    }
}
