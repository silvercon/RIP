package com.Thread;

/*------------------------------------------------------
 * A. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的锁是对象；
 * 如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。 
 * B. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。 
 * C. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。
 ------------------------------------------------------*/
public class Synchronized implements Runnable {
    int i = 1;

    /*------------------------------------------------------
     * 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞。
     ------------------------------------------------------*/
    public void sync() {
        synchronized (this) {
            while (i < 10) {
                System.out
                    .println(Thread.currentThread().getName() + ":" + i++);
            }
        }
    }

    /*------------------------------------------------------
     * 当一个线程访问对象的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。
     ------------------------------------------------------*/
    public void nonSync() {
        while (i < 10) {
            System.out.println(Thread.currentThread().getName() + ":" + i++);
        }
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.contains("A")) {
            sync();
        } else if (threadName.contains("B")) {
            nonSync();
        }
    }

    public static void main(String args[]) {
        Synchronized synchronized1 = new Synchronized();
        new Thread(synchronized1, "Thread-A").start();
        new Thread(synchronized1, "Thread-B").start();
    }
}
