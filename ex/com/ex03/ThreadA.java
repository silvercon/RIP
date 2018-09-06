package com.ex03;

public class ThreadA extends Thread {
    private ObjectService objectService;

    public ThreadA(ObjectService objectService, String name) {
        super();
        this.objectService = objectService;
        setName(name);
    }

    @Override
    public void run() {
        objectService.writeFile(String.valueOf(System.currentTimeMillis()),
            "字符串A");
    }

}
