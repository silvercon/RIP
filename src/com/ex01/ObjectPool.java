package com.ex01;

import java.util.Stack;

public class ObjectPool implements Runnable {

    ObjectPool() {
    }

    ObjectPool(String objectId) {
        this.objectId = objectId;
    }

    /**
     * 对象ID
     */
    private String objectId;

    /**
     * 对象池
     */
    private static Stack<ObjectPool> pool = new Stack<ObjectPool>();

    /**
     * 对象池数量下限
     */
    private static int minObjectCount = 5;

    /**
     * 对象池数量上限
     */
    private static int maxObjectCount = 20;

    /**
     * 当前对象池中的对象数量
     */
    private static int curObjectCount = 0;

    public String getObjectId() {
        return objectId;
    }

    /**
     * 初始化对象池
     */
    private void initPools() {
        while (curObjectCount < minObjectCount) {
            ObjectPool objectPool = new ObjectPool("Object" + curObjectCount);

            recycleObject(objectPool);
            curObjectCount++;
        }

        // printPool();
    }

    /**
     * 创建对象
     */
    private ObjectPool createObject() {

        synchronized (pool) {
            if (pool.size() > 0) {
                return pool.pop();
            }

            if (curObjectCount < maxObjectCount && maxObjectCount > 0) {
                return new ObjectPool("Object" + ++curObjectCount);
            }

            return null;
        }

    }

    /**
     * 回收对象
     */
    private void recycleObject(ObjectPool objectPool) {

        pool.push(objectPool);

    }

    /**
     * 打印对象池状态
     */
    private void printPool() {
        System.out.println("当前对象池中对象数量:" + pool.size());

        if (!pool.isEmpty()) {
            for (ObjectPool objectPool : pool) {
                System.out.println("  " + objectPool.getObjectId());
            }
        }

    }

    public static void main(String args[]) {
        Thread thread = new Thread(new ObjectPool());
        thread.start();
    }

    @Override
    public void run() {

        initPools();

        while (curObjectCount < maxObjectCount) {
            createObject();
        }

        printPool();
    }
}
