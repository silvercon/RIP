package com.ex02;

public class ex02 {

    /**
     * 多个线程调用同一个对象中的不同名称的synchronized同步方法或synchronized(this)同步代码块时，是同步的;
     * 1、synchronized同步方法
     * ①对其它的synchronized同步方法或synchronized(this)同步代码块调用是堵塞状态；
     * ②同一时间只有一个线程执行synchronized同步方法中的代码。
     * 2、synchronized(this)同步代码块
     * ①对其它的synchronized同步方法或synchronized(this)同步代码块调用是堵塞状态；
     * ②同一时间只有一个线程执行synchronized同步方法中的代码。
     */

}
