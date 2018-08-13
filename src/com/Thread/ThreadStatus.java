package com.Thread;

import java.lang.management.ManagementFactory;

public class ThreadStatus implements Runnable {

    /*
     * A thread state. A thread can be in one of the following states: NEW A
     * thread that has not yet started is in this state. RUNNABLE A thread
     * executing in the Java virtual machine is in this state. BLOCKED A thread
     * that is blocked waiting for a monitor lock is in this state. WAITING A
     * thread that is waiting indefinitely for another thread to perform a
     * particular action is in this state. TIMED_WAITING A thread that is
     * waiting for another thread to perform an action for up to a specified
     * waiting time is in this state. TERMINATED A thread that has exited is in
     * this state. A thread can be in only one state at a given point in time.
     * These states are virtual machine states which do not reflect any
     * operating system thread states.
     */

    @Override
    public void run() {
        /*
         * 就绪（RUNNABLE）状态：调用start()方法。
         */
        System.out.println(Thread.currentThread().getState());

        /*
         * 调用sleep方法后线程超时等待（TIME_WAITING）状态，但是不会释放对象锁。
         */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static String pid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        return name.split("@")[0];
    }

    public static void runnable() {
        long i = 0;
        while (true) {
            i++;
        }
    }

    public static void blocked() {
        final Object lock = new Object();
        new Thread() {
            public void run() {
                synchronized (lock) {
                    System.out.println("i got lock, but don't release");
                    try {
                        Thread.sleep(1000L * 1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        synchronized (lock) {
            try {
                Thread.sleep(30 * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void timedWaiting() {
        final Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait(30 * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void waiting() {
        final Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String args[]) {
        /*
         * 新建状态（NEW）：新创建了一个线程对象。
         */
        ThreadStatus threadStatus = new ThreadStatus();
        Thread thread1 = new Thread(threadStatus);
        System.out.println(thread1.getState());

        /*
         * 调用start()方法后，调度程序开始调用线程，如果被调用则执行run()方法并进入RUNNABLE状态，
         * 否则进入TIMED_WAITING状态。
         */
        thread1.start();

    }
}
