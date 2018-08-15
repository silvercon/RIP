package com.Thread;

public class RunnableThread implements Runnable {
    int count = 1;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + count++);
    }

    public static void main(String args[]) {
        /*---------------------------------------------------
         * Runnable线程可共享线程资源
         ---------------------------------------------------*/
        RunnableThread runnableThread = new RunnableThread();

        new Thread(runnableThread).start();
        new Thread(runnableThread).start();
    }
}
