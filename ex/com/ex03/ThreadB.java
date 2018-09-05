package com.ex03;

public class ThreadB extends Thread {
    private ObjectService objectService;

    public ThreadB(ObjectService objectService, String name) {
        super();
        this.objectService = objectService;
        setName(name);
    }

    @Override
    public void run() {
        objectService.writeFile(String.valueOf(System.currentTimeMillis()),
            "字符串B");
    }

}
