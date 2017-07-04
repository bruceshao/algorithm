/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: DBUtilTest.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月29日, Create
 */
package com.bruceshao.other;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class DBUtilTest
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<Integer> f = executor.submit(new Callable<Integer>()
        {

            @Override
            public Integer call() throws Exception
            {
                System.out.println("----- 正在执行 -----");
                Thread.sleep(2000);
                return 2000;
            }
        });
        System.out.println("----- 我是分割线 -----");
        System.out.println("----- " + f.get() + " -----");
    }
}
