package com.ex03;

public class MainTest2 {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();

        ThreadC c = new ThreadC(service, "C");
        ThreadD d = new ThreadD(service, "D");

        c.start();
        d.start();
    }

}
