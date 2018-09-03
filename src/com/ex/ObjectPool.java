package com.ex;

import java.util.Stack;

public class ObjectPool {

    ObjectPool(String objectName) {
        this.objectName = objectName;
    }

    /**
     * 对象名称
     */
    private String objectName;

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

    public String getObjectName() {
        return objectName;
    }

    /**
     * 创建对象
     */
    private ObjectPool createObject() {

        if (pool.size() > 0) {
            return pool.pop();
        }

        if (curObjectCount < maxObjectCount && maxObjectCount > 0) {
            curObjectCount++;
            return new ObjectPool("Object" + curObjectCount);
        }

        return null;
    }

    /**
     * 回收对象
     */
    private void recycleObject(ObjectPool objectPool) {

        pool.push(objectPool);

    }

    /**
     * 初始化对象池
     */
    private void initPools() {
        while (curObjectCount < minObjectCount) {
            ObjectPool objectPool = new ObjectPool("Object" + curObjectCount);

            pool.push(objectPool);
            curObjectCount++;
        }

        System.out.println("当前对象池中对象数量:" + pool.size());
    }

    public static void main(String args[]) {
        ObjectPool objectPool = new ObjectPool("main");

        objectPool.initPools();

        while (curObjectCount < maxObjectCount) {
            objectPool.createObject();
        }

        System.out.println("当前对象池中对象数量:" + pool.size());
    }
}
