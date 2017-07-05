/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: ThreadA.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年7月4日, Create
 */
package com.bruceshao.lock;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class ThreadB extends Thread
{
    private Object obj;

    public ThreadB(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e1)
        {
            e1.printStackTrace();
        }
        synchronized (obj)
        {
            System.out.println(Thread.currentThread().getName() + " start");
            obj.notify(); // 释放锁
            System.out.println(Thread.currentThread().getName() + " release");
        }
    }
}
