/*
 * Copyright (c) 2008-2016 浩瀚深度 All Rights Reserved.
 *
 * FileName: QuickSort.java
 *
 * Description：
 *
 * History:
 * v1.0.0, hhszg, 2017年6月5日, Create
 */
package com.bruceshao.sort;

/**
 * 
 * @author hhszg
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class QuickSort
{
    public static void main(String[] args)
    {
        int[] nums = {1,3,6,7,9,5,4,2,8};
        quickSort(nums, 0 , nums.length - 1);
        for (int i : nums)
        {
            System.out.print(i + " ");
        }
    }
    
    public static void quickSort(int[] nums, int left, int right)
    {
        if (left >= right)
        {
            return;
        }
        int i = left;
        int j = right;
        int key = nums[left];
        while (i < j)
        {
            while (i < j && nums[j] >= key)
            {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= key)
            {
                i++;
            }
            nums[j] = nums[i];
            nums[i] = key;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }
    
}
