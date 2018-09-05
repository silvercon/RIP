package com.ex02;

public class ThreadE extends Thread {
    private ObjectService objectService;

    public ThreadE(ObjectService objectService, String name) {
        super();
        this.objectService = objectService;
        setName(name);
    }

    @Override
    public void run() {
        super.run();
        objectService.objectMethodB();
    }
}
