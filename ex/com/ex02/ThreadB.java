package com.ex02;

public class ThreadB extends Thread {
    private ObjectService objectService;

    public ThreadB(ObjectService objectService, String name) {
        super();
        this.objectService = objectService;
        setName(name);
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodB();
    }
}
