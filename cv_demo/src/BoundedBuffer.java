import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    private final String[] buffer;
    private final int capacity;

    private int front;
    private int rear;
    private int count;

    private final Lock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public BoundedBuffer(int capacity) {
        super();

        this.capacity = capacity;

        buffer = new String[capacity];
    }

    public void deposit(String data) throws InterruptedException {
        lock.lock();

        try {
            while (count == capacity) {
                notFull.await();
            }

            buffer[rear] = data;
            rear = (rear + 1) % capacity;
            count++;
            System.out.println("thread" + Thread.currentThread().getId() + ", deposes " + data);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public String fetch() throws InterruptedException {
        lock.lock();

        try {
            while (count == 0) {
                notEmpty.await();
            }

            String result = buffer[front];
            front = (front + 1) % capacity;
            count--;

            notFull.signal();
            System.out.println("thread" + Thread.currentThread().getId() + ", fetches " + result);
            return result;
        } finally {
            lock.unlock();
        }
    }

    private static final int NUM_PRODUCERS = 1;
    private static final int NUM_CONSUMER = 5;

    private static class Producer implements Runnable {
        BoundedBuffer buffer;
        String value;
        int numItems;

        public Producer(BoundedBuffer b,  int numItems) {
            buffer = b;
            this.numItems = numItems;
        }

        @Override
        public void run() {
            for (int i = 0; i < numItems; i++) {
                try {
                    buffer.deposit(String.valueOf(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        BoundedBuffer buffer;
        String value;

        public Consumer(BoundedBuffer b) {
            buffer = b;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    value = buffer.fetch();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
        static public void main(String[] args) throws InterruptedException {
            BoundedBuffer buffer = new BoundedBuffer(10);
            Thread p1, c1, c2;
            p1 = new Thread(new Producer(buffer, 20));
            c1 = new Thread(new Consumer(buffer));
            c2 = new Thread(new Consumer(buffer));
            p1.start();
            c1.start();
            c2.start();
            p1.join();
            c1.join();
            c2.join();
        }
    }
