/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: InsertSort.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月26日, Create
 */
package com.bruceshao.sort;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class InsertSort
{
    public static void main(String[] args)
    {
        int[] nums = {5, 3, 4, 2, 6, 1, 7};
        
        // 插入排序思想：
        // 1、从第二个数字开始往后遍历，（因为第一个数只有一个那么一定是排序好的）
        // 2、将这个数字与前面的所有数字进行比较，如果比前面的数字小则进行交换
        // 3、直到遇到比当前值小或者到头......
        for (int num : nums)
        {
            System.out.print(num + " ");
        }
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > value)
            {
                nums[j+1] = nums[j]; // 将j+1的值赋值为j的值
                nums[j--] = value; // 将j的值赋值为value
            }
        }
        System.out.println("\r\n------- 我是分割线  ------");
        for (int num : nums)
        {
            System.out.print(num + " ");
        }
    }
}
