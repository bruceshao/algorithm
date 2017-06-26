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
public class InterruptTest1
{
    public static void main(String[] args) throws InterruptedException
    {
        Runnable t1 = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(4000);
                    System.out.println("----- 无中断 -----");
                }
                catch (InterruptedException e)
                {
                    System.out.println("------- 有中断发生 ------");
                    Thread.interrupted();
                    System.out.println("------- 清除中断 -----");
                }
            }
        };
        Thread t = new Thread(t1);
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }
}