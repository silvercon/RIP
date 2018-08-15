package com.Thread;

class DeadThread1 extends Thread {
    private DeadLock deadLock;

    public DeadThread1(DeadLock deadLock) {
        super();
        this.deadLock = deadLock;
    }

    public DeadLock getDeadLock() {
        return deadLock;
    }

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    public void run() {
        try {
            deadLock.left2Right();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DeadThread2 extends Thread {
    private DeadLock deadLock;

    public DeadThread2(DeadLock deadLock) {
        super();
        this.deadLock = deadLock;
    }

    public DeadLock getDeadLock() {
        return deadLock;
    }

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    public void run() {
        try {
            deadLock.right2Left();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

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

    /*------------------------------------------------------------------------  
     运行程序后回发生死锁，不会有任何输出。通过java自带工具可以查看堆栈线程信息。 
     jsp：当前执行的线程 
     jstack <pid>：jstack用于生成java虚拟机当前时刻的线程快照。
     ------------------------------------------------------------------------  */
    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        DeadThread1 t0 = new DeadThread1(dl);
        DeadThread2 t1 = new DeadThread2(dl);
        t0.start();
        t1.start();
    }
}
