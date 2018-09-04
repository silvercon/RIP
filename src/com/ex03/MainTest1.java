package com.ex03;

public class MainTest1 {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();

        ThreadA a = new ThreadA(service, "A");
        ThreadB b = new ThreadB(service, "B");

        a.start();
        b.start();
    }

}
