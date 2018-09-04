package com.ex02;

/**
 * 同一时间只能访问对象中的一个synchronized(this)代码块；
 * 当一个线程访问对象的synchronized(this)代码块时，其他线程访问同一个对象的其他synchronized(this)代码块时将是阻塞的；
 */
public class ObjectService {
    // ---------------------------------------------------------------------------MainTest1.serviceMethod

    /**
     * 将方法中的代码块使用synchronized(this)修饰，此时为同步
     */
    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out
                    .println("A begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out
                    .println("A end   time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        synchronized (this) {
            System.out.println("B begin time=" + System.currentTimeMillis());
            System.out.println("B end   time=" + System.currentTimeMillis());
        }
    }

    public void serviceMethodC() {
        System.out.println("C begin time=" + System.currentTimeMillis());
        System.out.println("C end   time=" + System.currentTimeMillis());
    }

    // ---------------------------------------------------------------------------MainTest2.objectMethod

    public void objectMethodA() {
        System.out.println("run----objectMethodA");
    }

    public void objectMethodB() {
        synchronized (this) {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("synchronized thread name:"
                            + Thread.currentThread().getName() + "-->i=" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                ;
            }
        }
    }

}
