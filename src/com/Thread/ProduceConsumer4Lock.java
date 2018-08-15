package com.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Consumer2 implements Runnable {

    private Lock lock;

    public Consumer2(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            try {
                lock.lock();
                System.out.println("B" + count--);

            } finally {
                lock.unlock();
                try {
                    Thread.sleep(91L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Producer2 implements Runnable {

    private Lock lock;

    public Producer2(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            try {
                lock.lock();
                System.out.println("A" + count--);

            } finally {
                lock.unlock();
                try {
                    Thread.sleep(90L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ProduceConsumer4Lock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Consumer2 consumer = new Consumer2(lock);
        Producer2 producer = new Producer2(lock);

        new Thread(consumer).start();
        new Thread(producer).start();
    }
}
