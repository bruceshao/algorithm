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
public class ThreadA extends Thread
{
    private Object obj;

    public ThreadA(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public void run()
    {
        synchronized (obj)
        {
            System.out.println(Thread.currentThread().getName() + " start");
            try
            {
                Thread.sleep(3000);
                obj.wait();// 挂起，等待其他线程获取锁
                System.out.println(Thread.currentThread().getName() + " get lock");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }// 挂起，等待其他线程获取锁
    }
}
