package com.Thread;

public class RunnableThread implements Runnable {

    @Override
    public void run() {
        int count = 10;

        while (count > 0) {
            System.out
                .println(Thread.currentThread().getName() + ": " + count--);
        }
    }

    public static void main(String args[]) {
        RunnableThread runnableThread1 = new RunnableThread();
        RunnableThread runnableThread2 = new RunnableThread();

        new Thread(runnableThread1).start();
        new Thread(runnableThread2).start();
    }
}
