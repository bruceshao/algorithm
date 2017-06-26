/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: ArrayMerge.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月26日, Create
 */
package com.bruceshao.other;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class ArrayMerge
{
    // 将两个有序数组合并（要求合并后保持顺序）
    public static void main(String[] args)
    {
        int[] first = {1, 4, 5, 7, 8};
        int[] second = {2, 6, 10, 12};
        int[] answers = new int[first.length + second.length];
        
        // 合并两个数组的方式比较简单
        // 1、同时遍历两个数组，对两个数组分别定义两个指针开始跑
        // 2、比较两个指针对应大小的值，然后插入到新的数组（注意新数组也需要一个指针）
        int i = 0, j = 0, k = 0;
        
        while (i < first.length && j < second.length)
        {
            if (first[i] < second[j])
            {
                answers[k++] = first[i++];
            }
            else
            {
                answers[k++] = second[j++];
            }
        }
        // 此时可能还存在问题需要处理：例如first还剩下或者second还剩下
        if (i == first.length) // first已经遍历到头了，剩下的都是second
        {
            while (j < second.length)
            {
                answers[k++] = second[j++];
            }
        }
        else
        {
            while (i < first.length)
            {
                answers[k++] = first[i++];
            }
        }
        for (int num : answers)
        {
            System.out.print(num + " ");
        }
    }
}
