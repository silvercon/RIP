package com.ex02;

public class MainTest1 {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();

        ThreadA threadA = new ThreadA(service, "A");
        ThreadB threadB = new ThreadB(service, "B");
        ThreadC threadC = new ThreadC(service, "C");

        /**
         * 同时启动ABC，其中AB为同步,C为异步
         * 首先执行A和C；此时B为阻塞，等待A执行完成
         */
        threadA.start();// synchronized (this)
        threadB.start();// synchronized (this)
        threadC.start();// non sync
    }
}
