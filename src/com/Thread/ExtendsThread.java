package com.Thread;

public class ExtendsThread extends Thread {
    int i = 1;

    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + i++);
    }

    public static void main(String args[]) {
        ExtendsThread extendsThread = new ExtendsThread();

        new Thread(extendsThread).start();
        new Thread(extendsThread).start();
    }
}
