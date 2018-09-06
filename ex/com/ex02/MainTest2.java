package com.ex02;

public class MainTest2 {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();

        ThreadD threadD = new ThreadD(service, "D");
        ThreadE threadE = new ThreadE(service, "E");

        threadE.start();// synchronized (this)

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            ;
        }

        threadD.start();// non sync
    }
}
