package com.ex02;

public class ThreadC extends Thread {
    private ObjectService objectService;

    public ThreadC(ObjectService objectService, String name) {
        super();
        this.objectService = objectService;
        setName(name);
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodC();
    }
}
