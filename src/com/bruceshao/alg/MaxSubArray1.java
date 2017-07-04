/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: MaxSubArray1.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年7月3日, Create
 */
package com.bruceshao.alg;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class MaxSubArray1
{
    /**
     * 最大子数组问题
     * 假如有一个数组{1, 7, 4, 5, 3, 2}
     * 求一个子数组{m, n}
     * 其中m和n为数组的指针，且array[n] - array[m]为最大，且n > m
     * @param args
     */
    public static void main(String[] args)
    {
        int[] nums = {10, 11, 7, 4, 6, 5};
        int[] subArray = baoliManage(nums);
        System.out.println(subArray[0] + " " + subArray[1]);
    }
    
    /**
     * 暴力求解，类似于冒泡的方式，双重遍历
     * @param nums
     * @return
     */
    private static int[] baoliManage(int[] nums)
    {
        int start = 0, end = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (max < (nums[j] - nums[i]))
                {
                    max = Math.max(max, nums[j] - nums[i]);
                    start = i;
                    end = j;
                }
            }
        }
        return new int[]{start, end};
    }
}
