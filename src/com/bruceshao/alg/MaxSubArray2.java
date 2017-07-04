/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: MaxSubArray2.java
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
public class MaxSubArray2
{
    /**
     *  同MaxSubArray1，但处理方式不同
     *  1、分而治之的处理
     *  2、首先判断的不
     *  2、将可能存在的结果置为3份，判断3份中的最大值
     *  
     *  
     *  同MaxSubArray1
     */
    /**
     * @param args
     */
    public static void main(String[] args)
    {
//        int[] nums = {-1, 10, -2, 3, 5, 6, 20, 11, -20, 21, 1, -22};
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++)
        {
            double m = Math.random();
            double n = Math.random();
            if (n > 0.5d)
            {
                nums[i] = (int)(-100000 * m);
            }
            else
            {
                nums[i] = (int)(100000 * m);
            }
        }
        long start = System.nanoTime();
        int[] subArray = minMaxManage(nums, 0, nums.length - 1);
        long end = System.nanoTime();
        System.out.println(subArray[0] + " " + subArray[1]);
        baoliManage(nums);
        long end2 = System.nanoTime();
        System.out.println("同治算法结果：" + (end - start) + "纳秒");
        System.out.println("暴力算法结果：" + (end2 - end) + "纳秒");
        
        /**
         * 同治算法结果：49939222纳秒
         * 暴力算法结果：2574574866纳秒
         * 相差了两个数量级......
         */
    }
    
    // 暴力方式，就是自己来直接遍历，取得最大的那个值
    public static void baoliManage(int[] nums)
    {
        int max = 0, left = 0, right = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for (int j = i; j < nums.length; j++)
            {
                sum += nums[j];
                if (sum > max)
                {
                    max = sum;
                    left = i;
                    right = j;
                }
            }
        }
        System.out.println(left + " " + right);
    }
    
    public static int[] minMaxManage(int[] nums, int left, int right)
    {
        if (left == right)
        {
            return new int[]{left, right, nums[left]};
        }
        else
        {
            int mid = (left + right)/2;
            int[] crossArray = crossManage(nums, left, mid, right);
            int[] leftArray = minMaxManage(nums, left, mid);
            int[] rightArray = minMaxManage(nums, mid + 1, right);
            if (crossArray[2] > leftArray[2] && crossArray[2] > rightArray[2])
            {
                return crossArray;
            }
            if (leftArray[2] > crossArray[2] && leftArray[2] > rightArray[2])
            {
                return leftArray;
            }
            else
            {
                return rightArray;
            }
        }
    }
    
    // 返回对象为：{left, right, size}
    public static int[] crossManage(int[] nums, int left, int mid, int right)
    {
        int sumLeft = 0, sum = 0, indexLeft = 0;
        for (int i = mid; i >= left; i--) // 求左侧最大值
        {
            sum += nums[i];
            if (sum > sumLeft)
            {
                sumLeft = sum;
                indexLeft = i;
            }
        }
        sum = 0;
        int sumRight = 0, indexRight = 0;
        for (int i = mid; i <= right; i++)
        {
            sum += nums[i];
            if (sum > sumRight)
            {
                sumRight = sum;
                indexRight = i;
            }
        }
        return new int[]{indexLeft, indexRight, sumLeft + sumRight};
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
