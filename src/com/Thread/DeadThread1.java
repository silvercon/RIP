package com.Thread;

public class DeadThread1 extends Thread {
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
