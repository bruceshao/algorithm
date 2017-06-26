/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: IteratorTest.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月14日, Create
 */
package com.bruceshao.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IteratorTest
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("zhaoliu");
//        int size = list.size();
//        for (int i = 0; i < size; i++)
//        {
//            if (list.get(i).equals("wangwu"))
//            {
//                list.remove(i);
//            }
//        }
        Iterator<String> it = list.iterator();
        while(it.hasNext())
        {
            if (it.next().equals("lisi"))
            {
                it.remove();
            }
        }
        for (String string : list)
        {
            System.out.println(string);
        }
    }
}
