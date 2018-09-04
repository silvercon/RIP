package com.ex03;

public class ObjectService {

    private String timeStamp;

    private String content;

    /**
     * 对象锁
     * 若将声明放在方法内，则同步不能生效
     */
    Object threadSync = new Object();

    // ---------------------------------------------------------------------------MainTest1
    public void writeFile(String timeStamp, String content) {
        try {

            synchronized (threadSync) {
                this.timeStamp = timeStamp;
                System.out
                    .println("thread name=" + Thread.currentThread().getName()
                            + " 进入代码块:" + this.timeStamp);

                Thread.sleep(1000);

                this.content = content;
                System.out
                    .println("thread name=" + Thread.currentThread().getName()
                            + " content:" + this.content);
            }
        } catch (InterruptedException e) {
            ;
        }
    }

    // ---------------------------------------------------------------------------MainTest2

    public void methodA() {
        try {
            synchronized (threadSync) {
                System.out.println("a begin");
                Thread.sleep(1000);
                System.out.println("a   end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB() {
        synchronized (this) {
            System.out.println("b begin");
            System.out.println("b   end");
        }
    }
}
