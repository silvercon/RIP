package com.Thread;

class Consumer implements Runnable {

    @Override
    public synchronized void run() {
        int count = 10;
        while (count > 0) {
            synchronized (ProduceConsumer4Sync.obj) {
                System.out.println("B" + count--);//
                ProduceConsumer4Sync.obj.notify();

                try {
                    ProduceConsumer4Sync.obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Producer implements Runnable {

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (ProduceConsumer4Sync.obj) {
                System.out.println("A" + count--);//
                ProduceConsumer4Sync.obj.notify();

                try {
                    ProduceConsumer4Sync.obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ProduceConsumer4Sync {
    public static final Object obj = new Object();

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}
