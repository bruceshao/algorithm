/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: InterruptTest.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月16日, Create
 */
package com.bruceshao.other;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class InterruptTest2
{
    public static void main(String[] args) throws InterruptedException
    {
        Runnable t1 = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("---- 我是一个线程 -----");
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e)
                {
                    System.out.println("------- 有异常发生 ------");
                    System.out.println(e.getMessage());
                }
            }
        };
        Thread t = new Thread(t1);
        t.start();
        Thread.sleep(100);
        t.interrupt();
    }
}