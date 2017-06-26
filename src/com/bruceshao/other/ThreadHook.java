/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: ThreadHook.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月19日, Create
 */
package com.bruceshao.other;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class ThreadHook
{
    public static void main(String[] args) throws InterruptedException
    {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("===== 我被关闭了 =====");
            }
        });
        
        
        
        while(true)
        {
            Thread.sleep(100);
            System.out.println("===== 我在运行 =====");
        }
    }
}
