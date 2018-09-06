package com.ex03;

public class ThreadC extends Thread {
    private ObjectService objectService;

    public ThreadC(ObjectService objectService, String name) {
        super();
        this.objectService = objectService;
        setName(name);
    }

    @Override
    public void run() {
        objectService.methodA();
    }

}
