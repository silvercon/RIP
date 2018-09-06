package com.ex02;

public class ThreadD extends Thread {
    private ObjectService objectService;

    public ThreadD(ObjectService objectService, String name) {
        super();
        this.objectService = objectService;
        setName(name);
    }

    @Override
    public void run() {
        super.run();
        objectService.objectMethodA();
    }
}
