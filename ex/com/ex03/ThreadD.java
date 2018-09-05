package com.ex03;

public class ThreadD extends Thread {
    private ObjectService objectService;

    public ThreadD(ObjectService objectService, String name) {
        super();
        this.objectService = objectService;
        setName(name);
    }

    @Override
    public void run() {
        objectService.methodB();
    }

}
