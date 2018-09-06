package com.ex02;

public class ThreadA extends Thread {
    private ObjectService objectService;

    public ThreadA(ObjectService objectService, String name) {
        super();
        this.objectService = objectService;
        setName(name);
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodA();
    }

}
