package com.Thread;

public class DeadThread2 extends Thread {
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
