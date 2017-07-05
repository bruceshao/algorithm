/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: LockTest.java
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
public class LockTest
{
    public static void main(String[] args)
    {
        Object obj = new Object();
        Thread a = new ThreadA(obj);
        Thread b = new ThreadB(obj);
        a.start();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
        }
        b.start();
    }
}
