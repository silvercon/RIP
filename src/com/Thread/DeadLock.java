package com.Thread;

public class DeadLock {
    private final Object left = new Object();

    private final Object right = new Object();

    public void left2Right() throws Exception {
        synchronized (left) {
            Thread.sleep(2000);
            synchronized (right) {
                System.out.println("left2Right end!");
            }
        }
    }

    public void right2Left() throws Exception {
        synchronized (right) {
            Thread.sleep(2000);
            synchronized (left) {
                System.out.println("right2Left end!");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        DeadThread1 t0 = new DeadThread1(dl);
        DeadThread2 t1 = new DeadThread2(dl);
        t0.start();
        t1.start();
    }
}
