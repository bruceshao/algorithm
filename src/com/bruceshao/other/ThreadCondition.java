/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: ThreadCondition.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月19日, Create
 */
package com.bruceshao.other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class ThreadCondition
{
    public static void main(String[] args)
    {
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        new Thread(){
            @Override
            public void run()
            {
                lock.lock(); // 加锁成功
                try
                {
                    System.out.println(Thread.currentThread().getName() + "==== 加锁成功 ====");
                    condition.await(); // 注意此处是await
                    System.out.println(Thread.currentThread().getName() + "==== 等待 ====");
                }
                catch(Exception e)
                {
                }
                finally
                {
                    lock.unlock();
                    System.out.println("=====释放1=====");
                }
            }
        }.start();
        
        new Thread(){

            @Override
            public void run()
            {
                lock.lock();
                try
                {
                    System.out.println(Thread.currentThread().getName() + "==== 获取锁成功 ====");
                    Thread.sleep(5000);
                    condition.signal();
                    System.out.println("===== 通知 =====");
                }
                catch (Exception e)
                {
                }
                finally
                {
                    lock.unlock();
                    System.out.println("=====释放2=====");
                }
            }
        }.start();
        
    }
}
